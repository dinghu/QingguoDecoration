package com.qing.guo.decoration.ui.activity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fkh.support.ui.activity.BaseActivity;
import com.qing.guo.decoration.R;
import com.qing.guo.decoration.entity.resp.Site;
import com.qing.guo.decoration.utils.AppUtils;
import com.zhy.view.flowlayout.TagFlowLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CaseDetailActivity extends BaseActivity {


    @BindView(R.id.icon)
    ImageView icon;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.tagLayout)
    TagFlowLayout tagLayout;
    @BindView(R.id.desc)
    TextView desc;
    @BindView(R.id.webView)
    WebView webView;

    @Override
    protected int getLayout() {
        return R.layout.activity_case_detail;
    }

    @Override
    protected void initView() {
        Site site = (Site) getIntent().getSerializableExtra("case");
        name.setText(site.getTitle());
        Glide.with(this).load(AppUtils.getImageUrl(site.getImg())).into(icon);
        webView.loadDataWithBaseURL(null, site.getDetail(), "text/html", "utf-8", null);
    }
}
