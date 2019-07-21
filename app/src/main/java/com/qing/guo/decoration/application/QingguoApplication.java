package com.qing.guo.decoration.application;

import android.app.Application;

import com.qing.guo.decoration.Constant.UrlConstant;
import com.qing.guo.decoration.retrofit.RetrofitHelper;

import me.shaohui.shareutil.ShareConfig;
import me.shaohui.shareutil.ShareManager;

public class QingguoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitHelper.init(this, UrlConstant.baseUrl);


        ShareConfig config = ShareConfig.instance()
                .qqId("1106175511")
                .wxId("wx49d2f0283a9cf034")
                .weiboId("59232439")
                // 下面两个，如果不需要登录功能，可不填写
                .weiboRedirectUrl("https://api.weibo.com/oauth2/default.html")
                .wxSecret("03430ced0458997a2b068556f89caa61");
        ShareManager.init(config);
    }
}
