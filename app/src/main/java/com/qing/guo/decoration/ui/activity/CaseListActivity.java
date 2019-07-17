package com.qing.guo.decoration.ui.activity;

import android.view.View;
import android.widget.AdapterView;

import com.makeramen.roundedimageview.RoundedImageView;
import com.qing.guo.decoration.R;
import com.qing.guo.decoration.base.BaseRefreshLoadListViewActivity;
import com.qing.guo.decoration.utils.ActivityUtils;

public class CaseListActivity extends BaseRefreshLoadListViewActivity<Integer, CaseListActivity.ViewHolder> {
    public class ViewHolder {
        private RoundedImageView image;

        public ViewHolder(View view) {
            image = (RoundedImageView) view.findViewById(R.id.image);
        }
    }

    @Override
    public int getItemLayout() {
        return R.layout.item_case;
    }

    @Override
    protected void initView() {
        mDatas.add(1);
        mDatas.add(2);
        super.initView();
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ActivityUtils.startActivity(CaseListActivity.this,CaseDetailActivity.class);
            }
        });
    }

    @Override
    protected String getTitleText() {
        return "案例";
    }

    @Override
    public CaseListActivity.ViewHolder getViewHolder(View convertView) {
        return null;
    }

    @Override
    public void initializeViews(int position, Integer integer, CaseListActivity.ViewHolder viewHolder) {

    }

    @Override
    public void getData(int page, boolean isRefreh) {

    }
}
