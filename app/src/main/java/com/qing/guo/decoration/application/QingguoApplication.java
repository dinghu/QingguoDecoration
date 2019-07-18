package com.qing.guo.decoration.application;

import android.app.Application;

import com.qing.guo.decoration.Constant.UrlConstant;
import com.qing.guo.decoration.retrofit.RetrofitHelper;

public class QingguoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitHelper.init(this, UrlConstant.baseUrl);
    }
}
