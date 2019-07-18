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
import com.qing.guo.decoration.entity.resp.ListResp;
import com.qing.guo.decoration.entity.resp.Product;
import com.qing.guo.decoration.entity.resp.QActivity;
import com.qing.guo.decoration.retrofit.ResponseListener;
import com.qing.guo.decoration.service.impl.ApiServiceImpl;
import com.qing.guo.decoration.utils.ActivityUtils;
import com.qing.guo.decoration.utils.AppUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dinghu on 2019/7/17.
 */
public class ActivityListActivity extends BaseRefreshLoadListViewActivity<QActivity, ActivityListActivity.ViewHolder> {


    @Override
    public int getItemLayout() {
        return R.layout.item_activity;
    }

    @Override
    protected void initView() {
        super.initView();
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ActivityListActivity.this, ActivityDetailActivity.class);
                intent.putExtra("activity", mDatas.get(i));
                ActivityUtils.startActivity(ActivityListActivity.this, intent);
            }
        });
    }

    @Override
    protected String getTitleText() {
        return "活动";
    }

    @Override
    public ViewHolder getViewHolder(View convertView) {
        return new ViewHolder(convertView);
    }

    @Override
    public void initializeViews(int position, QActivity qActivity, ViewHolder viewHolder) {
        viewHolder.desc.setText(qActivity.getDetail());
        viewHolder.title.setText(qActivity.getTitle());
        Glide.with(this).load(AppUtils.getImageUrl(qActivity.getImg())).into(viewHolder.image);
    }

    @Override
    public void getData(int page, boolean isRefreh) {
        ApiServiceImpl.getQActivityList(new ResponseListener<ListResp<QActivity>>() {
            @Override
            public void onSuccess(ListResp<QActivity> qActivityListResp) {
                dealDataRecive(qActivityListResp.list, true);
            }

            @Override
            public void onFail(String code, String message) {
                ToastUtils.showLong(message);
            }
        });
    }

    static class ViewHolder {
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