package com.qing.guo.decoration.utils;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.qing.guo.decoration.entity.User;
import com.qing.guo.decoration.entity.req.RongTokenReq;
import com.qing.guo.decoration.entity.resp.RongTokenResp;
import com.qing.guo.decoration.retrofit.ResponseListener;
import com.qing.guo.decoration.service.impl.ImServiceImpl;

import java.util.HashMap;
import java.util.Map;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.UserInfo;

/**
 * Created by dinghu on 2019/7/22.
 */
public class RongUtils {

    public static final String rongYunAvatar = "http://rongcloud-web.qiniudn.com/docs_demo_rongcloud_logo.png";

    public static void initRongChat(final Context context) {
        String userName = SPUtils.getInstance().getString("username");
        String userid = SPUtils.getInstance().getString("userid");
        String userAvatar = SPUtils.getInstance().getString("userAvatar");
        String rongToken = SPUtils.getInstance().getString("rongToken");
        if (!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(userid)) {

            userAvatar = TextUtils.isEmpty(userAvatar)? rongYunAvatar:userAvatar;

            setUserInfoProvider(userName, userid, userAvatar);

            if (TextUtils.isEmpty(rongToken)) {
                Map<String, String> map = new HashMap<>();
                map.put("name", userName);
                map.put("userId", userid);
                map.put("userAvatar", userAvatar);
                ImServiceImpl.getRongtoken(map, new ResponseListener<RongTokenResp>() {
                    @Override
                    public void onSuccess(RongTokenResp rongTokenResp) {
                        SPUtils.getInstance().put("rongToken", rongTokenResp.getToken());
                        //连接到服务器
                        connect(context, rongTokenResp.getToken());
                        addTestUserSupport(context);
                    }

                    @Override
                    public void onFail(String code, String message) {
                        ToastUtils.showLong(message);
                    }
                });
            } else {
                //连接到服务器
                connect(context, rongToken);
                addTestUserSupport(context);
            }
        }


    }

    private static void setUserInfoProvider(final String userName, final String userId, final String portraitUri) {
        RongIM.setUserInfoProvider(new RongIM.UserInfoProvider() {
            @Override
            public UserInfo getUserInfo(String s) {//用户信息提供者的S会改变，所以从服务器拿，参考微商猎手
                UserInfo userInfo = new UserInfo(userId, userName,
                        Uri.parse(TextUtils.isEmpty(portraitUri) ? "http://rongcloud-web.qiniudn.com/docs_demo_rongcloud_logo.png" :
                                AppUtils.getImageUrl(portraitUri)));
                return userInfo;
            }
        }, true);
    }

    public static void connect(final Context context, String rongToken) {
        RongIM.connect(rongToken, new RongIMClient.ConnectCallback() {
            @Override
            public void onTokenIncorrect() {

            }

            @Override
            public void onSuccess(String s) {
                Log.e("", "连接成功—————>" + s);
                Toast.makeText(context, "连接成功" + s, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {

            }
        });
    }

    public static User getSupportUser() {
        return new User("myzTestAccount", "测试用户", rongYunAvatar);
    }

    public static RongTokenReq userToRongTokenReq(User user) {
        RongTokenReq rongTokenReq = new RongTokenReq();
        rongTokenReq.name = user.name;
        rongTokenReq.userId = user.userId;
        rongTokenReq.portraitUri = user.portraitUri;
        return rongTokenReq;
    }

    public static Map<String, String> userToRongTokenMap(User user) {
        Map<String, String> map = new HashMap<>();
        map.put("name", user.name);
        map.put("userId", user.userId);
        map.put("userAvatar", user.portraitUri);
        return map;
    }

    public static void addTestUserSupport(final Context context) {

        Map<String, String> rongTokenReq = userToRongTokenMap(getSupportUser());

        ImServiceImpl.getRongtoken(rongTokenReq, new ResponseListener<RongTokenResp>() {
            @Override
            public void onSuccess(RongTokenResp rongTokenResp) {
                SPUtils.getInstance().put("rongToken", rongTokenResp.getToken());
                //连接到服务器
                connect(context, rongTokenResp.getToken());
            }

            @Override
            public void onFail(String code, String message) {
                ToastUtils.showLong(message);
            }
        });
    }
}
