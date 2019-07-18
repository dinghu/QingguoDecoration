package com.qing.guo.decoration.ui.activity;

import android.os.Bundle;
import android.text.Html;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.util.ScreenUtils;
import com.bumptech.glide.Glide;
import com.fkh.support.ui.activity.BaseActivity;
import com.qing.guo.decoration.R;
import com.qing.guo.decoration.entity.resp.ProductDetail;
import com.qing.guo.decoration.utils.AppUtils;
import com.scwang.smartrefresh.layout.util.DensityUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductDetailActivity extends BaseActivity {

    @BindView(R.id.icon)
    ImageView icon;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.desc)
    TextView desc;
    @BindView(R.id.webView)
    WebView webView;

    ProductDetail productDetail;

    @Override
    protected int getLayout() {
        return R.layout.activity_produce_detail;
    }

    @Override
    protected void initView() {
        productDetail = (ProductDetail) getIntent().getSerializableExtra("productDetail");
        AppUtils.initWebView(webView);
        desc.setText(productDetail.capital);
        name.setText(productDetail.title);
        Glide.with(this).load(AppUtils.getImageUrl(productDetail.img)).into(icon);
        webView.loadDataWithBaseURL(null,productDetail.detail, "text/html", "utf-8",null);
    }



}
