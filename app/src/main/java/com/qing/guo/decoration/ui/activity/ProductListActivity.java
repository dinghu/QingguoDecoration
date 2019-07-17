package com.qing.guo.decoration.ui.activity;

import android.view.View;
import android.widget.AdapterView;

import com.qing.guo.decoration.R;
import com.qing.guo.decoration.base.BaseRefreshLoadListViewActivity;
import com.qing.guo.decoration.utils.ActivityUtils;

/**
 * Created by dinghu on 2019/7/17.
 */
public class ProductListActivity extends BaseRefreshLoadListViewActivity<Integer, ProductListActivity.ViewHolder> {
    public class ViewHolder {

    }

    @Override
    protected void initView() {
        mDatas.add(1);
        mDatas.add(2);
        super.initView();
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ActivityUtils.startActivity(ProductListActivity.this,SiteDetailActivity.class);
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
        return null;
    }

    @Override
    public void initializeViews(int position, Integer integer, ViewHolder viewHolder) {

    }

    @Override
    public void getData(int page, boolean isRefreh) {

    }
}
