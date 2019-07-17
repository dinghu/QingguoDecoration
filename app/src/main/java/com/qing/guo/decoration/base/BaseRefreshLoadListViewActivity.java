package com.qing.guo.decoration.base;

import com.fkh.support.ui.activity.RefreshLoadListViewActivity;
import com.fkh.support.ui.widget.TitleView;
import com.qing.guo.decoration.R;

/**
 * Created by dinghu on 2019/7/17.
 */
public abstract class BaseRefreshLoadListViewActivity<T, ViewHolder> extends RefreshLoadListViewActivity<T, ViewHolder> {

    @Override
    protected int getLayout() {
        return R.layout.common_refresh_list;
    }

    @Override
    protected void initView() {
        ((TitleView) findViewById(R.id.titleView)).setTitleText(getTitleText());
    }

    protected abstract String getTitleText();
}
