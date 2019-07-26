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
import com.qing.guo.decoration.entity.resp.Site;
import com.qing.guo.decoration.retrofit.ResponseListener;
import com.qing.guo.decoration.service.impl.ApiServiceImpl;
import com.qing.guo.decoration.utils.ActivityUtils;
import com.qing.guo.decoration.utils.AppUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CaseListActivity extends BaseRefreshLoadListViewActivity<Site, CaseListActivity.ViewHolder> {
    static

    public class ViewHolder {
        @BindView(R.id.image)
        RoundedImageView image;
        @BindView(R.id.scan_num)
        TextView scanNum;
        @BindView(R.id.title)
        TextView title;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    @Override
    public int getItemLayout() {
        return R.layout.item_case;
    }

    @Override
    protected void initView() {
        super.initView();
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(CaseListActivity.this, CaseDetailActivity.class);
                intent.putExtra("case",mDatas.get(i));
                ActivityUtils.startActivity(CaseListActivity.this,intent);
            }
        });
    }

    @Override
    protected String getTitleText() {
        return "案例";
    }

    @Override
    public ViewHolder getViewHolder(View convertView) {
        return new ViewHolder(convertView);
    }

    @Override
    public void initializeViews(int position, Site site, ViewHolder viewHolder) {
        viewHolder.title.setText(site.getTitle());
        Glide.with(this).load(AppUtils.getImageUrl(site.getImg())).into(viewHolder.image);
    }

    @Override
    public void getData(int page, boolean isRefreh) {
        Map<String, String> params = new HashMap<>();
        params.put("rate", "Y");
        ApiServiceImpl.getSiteList(params, new ResponseListener<ListResp<Site>>() {
            @Override
            public void onSuccess(ListResp<Site> siteListResp) {
                dealDataRecive(siteListResp.list, true);
            }

            @Override
            public void onFail(String code, String message) {
                ToastUtils.showLong(message);
            }
        });
    }

}
