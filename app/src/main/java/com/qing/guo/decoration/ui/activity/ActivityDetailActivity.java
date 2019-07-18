package com.qing.guo.decoration.ui.activity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fkh.support.ui.activity.BaseActivity;
import com.qing.guo.decoration.R;
import com.qing.guo.decoration.entity.resp.ProductDetail;
import com.qing.guo.decoration.entity.resp.QActivity;
import com.qing.guo.decoration.utils.AppUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityDetailActivity extends BaseActivity {
    @BindView(R.id.icon)
    ImageView icon;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.desc)
    TextView desc;
    @BindView(R.id.webView)
    WebView webView;

    QActivity qActivity;

    @Override
    protected int getLayout() {
        return R.layout.activity_activity_detail;
    }

    @Override
    protected void initView() {
        qActivity = (QActivity) getIntent().getSerializableExtra("activity");
        AppUtils.initWebView(webView);
        name.setText(qActivity.getTitle());
        Glide.with(this).load(AppUtils.getImageUrl(qActivity.getImg())).into(icon);
        webView.loadDataWithBaseURL(null,qActivity.getDetail(), "text/html", "utf-8",null);
    }


}
