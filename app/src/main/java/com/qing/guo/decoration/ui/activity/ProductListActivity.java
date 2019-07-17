package com.qing.guo.decoration.ui.activity;

import android.view.View;

import com.qing.guo.decoration.base.BaseRefreshLoadListViewActivity;

/**
 * Created by dinghu on 2019/7/17.
 */
public class ProductListActivity extends BaseRefreshLoadListViewActivity<Integer, ProductListActivity.ViewHolder> {
    public class ViewHolder {

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
