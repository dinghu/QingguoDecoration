package com.qing.guo.decoration.base;

import android.os.Bundle;

import com.fkh.support.ui.activity.RefreshLoadListViewActivity;
import com.fkh.support.ui.widget.TitleView;
import com.qing.guo.decoration.R;

/**
 * Created by dinghu on 2019/7/17.
 */
public abstract class BaseRefreshLoadListViewActivity<T, ViewHolder> extends RefreshLoadListViewActivity<T, ViewHolder> {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_refresh_list);
        ((TitleView) findViewById(R.id.title)).setTitleText(getTitleText());
    }

    protected abstract String getTitleText();
}
