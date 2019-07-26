package com.qing.guo.decoration.ui.activity;

import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.fkh.support.ui.activity.BaseActivity;
import com.qing.guo.decoration.R;
import com.qing.guo.decoration.entity.resp.BaseResp;
import com.qing.guo.decoration.retrofit.ResponseListener;
import com.qing.guo.decoration.service.impl.ApiServiceImpl;
import com.qing.guo.decoration.utils.RongUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;
import me.shaohui.shareutil.LoginUtil;
import me.shaohui.shareutil.login.LoginListener;
import me.shaohui.shareutil.login.LoginPlatform;
import me.shaohui.shareutil.login.LoginResult;
import me.shaohui.shareutil.login.result.BaseUser;

public class LoginActivity extends BaseActivity {
    @BindView(R.id.weichat)
    ImageView weichat;
    @BindView(R.id.qq)
    ImageView qq;
    @BindView(R.id.weibo)
    ImageView weibo;
    @BindView(R.id.deal)
    TextView deal;

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {


    }


    private void saveUser(LoginResult result) {
        Map<String, String> map = new HashMap<>();
        map.put("openid", result.getToken().getOpenid());
        BaseUser bu = result.getUserInfo();
        map.put("username", bu.getNickname());
        map.put("headimage", bu.getHeadImageUrl());
        ApiServiceImpl.saveUser(map, new ResponseListener<BaseResp>() {
            @Override
            public void onSuccess(BaseResp baseResp) {
                ToastUtils.showLong("登录成功");
                finish();
            }

            @Override
            public void onFail(String code, String message) {
                ToastUtils.showLong(message);
            }
        });
    }

    @OnClick(R.id.weichat)
    public void onViewClicked() {
//        SPUtils.getInstance().put("username", "测试账号");
//        SPUtils.getInstance().put("userid", "ceshizhanghao");

        LoginUtil.login(LoginActivity.this, LoginPlatform.WX, new LoginListener() {
            @Override
            public void loginSuccess(LoginResult result) {
//                saveUser(result);
                ToastUtils.showLong("登录成功");
                SPUtils.getInstance().put("userid", result.getUserInfo().getOpenId());
                SPUtils.getInstance().put("username", result.getUserInfo().getNickname());
                SPUtils.getInstance().put("userAvatar", result.getUserInfo().getHeadImageUrl());
                //融云初始化
                RongUtils.initRongChat(getApplicationContext());
                finish();
            }

            @Override
            public void loginFailure(Exception e) {
                ToastUtils.showLong(e.getMessage());
                finish();
            }

            @Override
            public void loginCancel() {
                ToastUtils.showLong("登录取消");
            }
        }, true);
    }
}
