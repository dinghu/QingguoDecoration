package com.qing.guo.decoration.ui.activity;

import android.view.View;
import android.widget.AdapterView;

import com.qing.guo.decoration.R;
import com.qing.guo.decoration.base.BaseRefreshLoadListViewActivity;
import com.qing.guo.decoration.utils.ActivityUtils;

/**
 * Created by dinghu on 2019/7/17.
 */
public class ActivityListActivity extends BaseRefreshLoadListViewActivity<Integer, ActivityListActivity.ViewHolder> {
    public class ViewHolder {

    }

    @Override
    public int getItemLayout() {
        return R.layout.item_activity;
    }

    @Override
    protected void initView() {
        mDatas.add(1);
        mDatas.add(2);
        super.initView();
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ActivityUtils.startActivity(ActivityListActivity.this,ActivityDetailActivity.class);
            }
        });
    }

    @Override
    protected String getTitleText() {
        return "活动";
    }

    @Override
    public ActivityListActivity.ViewHolder getViewHolder(View convertView) {
        return null;
    }

    @Override
    public void initializeViews(int position, Integer integer, ActivityListActivity.ViewHolder viewHolder) {

    }

    @Override
    public void getData(int page, boolean isRefreh) {

    }
}