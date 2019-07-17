package com.qing.guo.decoration.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.fkh.support.ui.activity.RefreshLoadListViewActivity;
import com.qing.guo.decoration.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dinghu on 2019/7/17.
 */
public class SiteListActivity extends RefreshLoadListViewActivity<Integer, SiteListActivity.ViewHolder> {


    @BindView(R.id.communityTv)
    TextView communityTv;
    @BindView(R.id.communityLayout)
    LinearLayout communityLayout;
    @BindView(R.id.styleTv)
    TextView styleTv;
    @BindView(R.id.styleLayout)
    LinearLayout styleLayout;
    @BindView(R.id.stageTv)
    TextView stageTv;
    @BindView(R.id.stageLayout)
    LinearLayout stageLayout;
    @BindView(R.id.sortTv)
    TextView sortTv;
    @BindView(R.id.sortLayout)
    LinearLayout sortLayout;
    @BindView(R.id.list)
    ListView list;
    @BindView(R.id.smartRefreshLayout)
    SmartRefreshLayout smartRefreshLayout;
    @BindView(R.id.noDataView)
    TextView noDataView;

    public class ViewHolder {

    }

    @Override
    public int getItemLayout() {
        return R.layout.item_site;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_site_list;
    }

    @Override
    protected void initView() {

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
