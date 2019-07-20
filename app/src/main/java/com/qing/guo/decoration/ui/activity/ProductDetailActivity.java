package com.qing.guo.decoration.ui.activity;

import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fkh.support.ui.activity.BaseActivity;
import com.qing.guo.decoration.R;
import com.qing.guo.decoration.entity.resp.ProductDetail;
import com.qing.guo.decoration.utils.AppUtils;

import butterknife.BindView;

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
