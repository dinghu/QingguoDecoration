package com.qing.guo.decoration.utils;

import android.content.Context;
import android.text.TextUtils;

import com.blankj.utilcode.util.SPUtils;
import com.qing.guo.decoration.ui.activity.LoginActivity;

/**
 * Created by dinghu on 2019/7/22.
 */
public class UserUtils {
    public static boolean isLogin(){
        String userName = SPUtils.getInstance().getString("username");
        return !TextUtils.isEmpty(userName);
    }

    public static String getLoginName(){
        String userName = SPUtils.getInstance().getString("username");
        return userName;
    }

    public static void reqLogin(Context context) {
        ActivityUtils.startActivity(context, LoginActivity.class);
    }
}
