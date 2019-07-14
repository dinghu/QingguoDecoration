package com.fkh.support.ui.activity;

import android.content.Context;
import android.view.View;
import android.widget.AbsListView;

import com.fkh.support.ui.adapter.BaseListAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.List;

public abstract class RefreshLoadListViewActivity<T> extends RefreshLoadActivity<T> {

    private AbsListView listView;
    private BaseListAdapter adapter;
    private int itemLayout;

    public void bindView(SmartRefreshLayout smartRefreshLayout, AbsListView listView, List<T> mData, int itemLayout) {
        super.bindView(smartRefreshLayout, mData);
        this.listView = listView;
        this.itemLayout = itemLayout;
        adapter = new ListAdapter(this, mData);
        this.listView.setAdapter(this.adapter);
    }

    public AbsListView getListView() {
        return listView;
    }

    public BaseListAdapter getAdapter() {
        return adapter;
    }

    @Override
    public void notifyDataSetChanged(boolean noMoreData) {
        super.notifyDataSetChanged(noMoreData);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void dealError(String message) {
        super.dealError(message);
    }

    public abstract Object getViewHolder(View convertView);

    public abstract void initializeViews(int position, T t, Object holder);


    private class ListAdapter extends BaseListAdapter<T> {

        public ListAdapter(Context context, List<T> list) {
            super(list, context);
        }

        @Override
        public int getItemLayout() {
            return itemLayout;
        }

        @Override
        public Object getViewHolder(View convertView) {
            return RefreshLoadListViewActivity.this.getViewHolder(convertView);
        }

        @Override
        public void initializeViews(int position, T object, Object holder) {
            RefreshLoadListViewActivity.this.initializeViews(position, object, holder);
        }
    }
}
