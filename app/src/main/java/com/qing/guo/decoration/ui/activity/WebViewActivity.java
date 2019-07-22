package com.qing.guo.decoration.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.fkh.support.ui.activity.BaseActivity;
import com.fkh.support.ui.widget.TitleView;
import com.qing.guo.decoration.R;

import butterknife.BindView;

public class WebViewActivity extends BaseActivity {

    @BindView(R.id.titleView)
    TitleView mTitle;
    @BindView(R.id.webview)
    WebView mWebView;

    public static void start(Context context, String title, String url) {
        Intent intent = new Intent(context, WebViewActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("url", url);
        context.startActivity(intent);
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_webview;
    }

    @Override
    protected void initView() {
        String title = getIntent().getStringExtra("title");
        String url = getIntent().getStringExtra("url");
        mTitle.setTitleText(title);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewController());
        mWebView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                mTitle.setTitleText(title);
            }
        });
        mWebView.loadUrl(url);
    }


    // 加载网页
    public class WebViewController extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // hide element by class name
            super.onPageFinished(view, url);
        }


    }

}
