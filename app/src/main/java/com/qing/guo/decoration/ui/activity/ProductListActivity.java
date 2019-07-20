package com.qing.guo.decoration.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;
import com.qing.guo.decoration.R;
import com.qing.guo.decoration.base.BaseRefreshLoadListViewActivity;
import com.qing.guo.decoration.entity.resp.DataResp;
import com.qing.guo.decoration.entity.resp.ListResp;
import com.qing.guo.decoration.entity.resp.Product;
import com.qing.guo.decoration.entity.resp.ProductDetail;
import com.qing.guo.decoration.retrofit.ResponseListener;
import com.qing.guo.decoration.service.impl.ApiServiceImpl;
import com.qing.guo.decoration.utils.ActivityUtils;
import com.qing.guo.decoration.utils.AppUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dinghu on 2019/7/17.
 */
public class ProductListActivity extends BaseRefreshLoadListViewActivity<Product, ProductListActivity.ViewHolder> {

    @Override
    protected void initView() {
        super.initView();
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
                Product product = mDatas.get(i);
                showLoading();
                ApiServiceImpl.getProductDetail(product.id, new ResponseListener<DataResp<ProductDetail>>() {
                    @Override
                    public void onSuccess(DataResp<ProductDetail> productDetailDataResp) {
                        hideLoading();
                        Intent intent = new Intent(ProductListActivity.this, ProductDetailActivity.class);
                        intent.putExtra("productDetail", productDetailDataResp.data);
                        ActivityUtils.startActivity(ProductListActivity.this, intent);
                    }

                    @Override
                    public void onFail(String code, String message) {
                        hideLoading();
                        ToastUtils.showLong(message);
                    }
                });
            }
        });

    }

    @Override
    public int getItemLayout() {
        return R.layout.item_product;
    }

    @Override
    protected String getTitleText() {
        return "产品管理";
    }

    @Override
    public ViewHolder getViewHolder(View convertView) {
        return new ViewHolder(convertView);
    }

    @Override
    public void initializeViews(int position, Product product, ViewHolder viewHolder) {
        viewHolder.desc.setText(product.capital);
        viewHolder.title.setText(product.title);
        Glide.with(this).load(AppUtils.getImageUrl(product.img)).into(viewHolder.image);
    }

    @Override
    public void getData(int page, boolean isRefreh) {
        ApiServiceImpl.getProductList(new ResponseListener<ListResp<Product>>() {
            @Override
            public void onSuccess(ListResp<Product> productListResp) {
                dealDataRecive(productListResp.list, true);
            }

            @Override
            public void onFail(String code, String message) {
                ToastUtils.showLong(message);
            }
        });
    }

    class ViewHolder {
        @BindView(R.id.image)
        RoundedImageView image;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.desc)
        TextView desc;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
