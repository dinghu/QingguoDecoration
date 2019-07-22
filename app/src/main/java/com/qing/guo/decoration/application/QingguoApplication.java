package com.qing.guo.decoration.application;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;

import com.qing.guo.decoration.Constant.UrlConstant;
import com.qing.guo.decoration.retrofit.RetrofitHelper;

import io.rong.imkit.RongIM;
import me.shaohui.shareutil.ShareConfig;
import me.shaohui.shareutil.ShareManager;

public class QingguoApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RetrofitHelper.init(this, UrlConstant.baseUrl);
        RongIM.init(this);


        ShareConfig config = ShareConfig.instance()
                .qqId("1106175511")
                .wxId("wx1ff77443f2f822f6")
                .weiboId("59232439")
                // 下面两个，如果不需要登录功能，可不填写
                .weiboRedirectUrl("https://api.weibo.com/oauth2/default.html")
                .wxSecret("03430ced0458997a2b068556f89caa61");
        ShareManager.init(config);
    }

    /**
     * 获得当前进程的名字
     *
     * @param context
     * @return
     */
    public static String getCurProcessName(Context context) {

        int pid = android.os.Process.myPid();

        ActivityManager activityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);

        for (ActivityManager.RunningAppProcessInfo appProcess : activityManager
                .getRunningAppProcesses()) {

            if (appProcess.pid == pid) {

                return appProcess.processName;
            }
        }
        return null;
    }
}
