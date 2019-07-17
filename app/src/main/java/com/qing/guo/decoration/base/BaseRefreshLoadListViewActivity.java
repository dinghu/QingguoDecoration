package com.qing.guo.decoration.base;

import android.widget.ListView;
import android.widget.TextView;

import com.fkh.support.ui.activity.RefreshLoadListViewActivity;
import com.fkh.support.ui.widget.TitleView;
import com.qing.guo.decoration.R;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by dinghu on 2019/7/17.
 */
public abstract class BaseRefreshLoadListViewActivity<T, ViewHolder> extends RefreshLoadListViewActivity<T, ViewHolder> {

    @BindView(R.id.titleView)
    TitleView titleView;
    @BindView(R.id.list)
    ListView list;
    @BindView(R.id.smartRefreshLayout)
    SmartRefreshLayout smartRefreshLayout;
    @BindView(R.id.noDataView)
    TextView noDataView;
    protected List<T> mDatas = new ArrayList<>();

    @Override
    protected int getLayout() {
        return R.layout.common_refresh_list;
    }

    @Override
    protected void initView() {
        ((TitleView) findViewById(R.id.titleView)).setTitleText(getTitleText());
        bindView(smartRefreshLayout, list, mDatas);
    }

    protected abstract String getTitleText();

}
