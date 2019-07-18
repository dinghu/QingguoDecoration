package com.qing.guo.decoration.utils;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.qing.guo.decoration.Constant.UrlConstant;

public class AppUtils {

    public static String getImageUrl(String orgUrl) {
        String targetUrl = orgUrl;
        if (!TextUtils.isEmpty(targetUrl)) {
            if (targetUrl.startsWith("http")) {
                return targetUrl;
            } else if (targetUrl.startsWith("/")) {
                return UrlConstant.imageBaseUrl + targetUrl;
            } else {
                return UrlConstant.imageBaseUrl + "/" + targetUrl;
            }

        }

        return orgUrl;
    }

    public static void initWebView(final WebView wb) {
        //设置WebView启用js
        wb.getSettings().setJavaScriptEnabled(true);
        //关闭自动适应
        wb.getSettings().setUseWideViewPort(false);
        wb.getSettings().setLoadWithOverviewMode(false);
        //重写WebViewClient中的onPageFinished方法
        wb.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                AppUtils.imgReset(wb);
            }
        });
    }

    /**
     * 循环遍历标签中的图片
     * js 语法
     */
    public static void imgReset(WebView wb) {
        wb.loadUrl("javascript:(function(){" +
                "var objs = document.getElementsByTagName('img'); " +
                "for(var i=0;i<objs.length;i++)  " +
                "{"
                + "var img = objs[i];   " +
                "    img.style.maxWidth = '100%';   " +
                "}" +
                "})()");
    }
}
