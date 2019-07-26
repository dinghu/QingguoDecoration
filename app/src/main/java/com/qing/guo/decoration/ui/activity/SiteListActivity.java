package com.qing.guo.decoration.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.fkh.support.ui.activity.RefreshLoadListViewActivity;
import com.fkh.support.ui.widget.ListSelectDialog;
import com.fkh.support.ui.widget.SecondaryListSelectDialog;
import com.makeramen.roundedimageview.RoundedImageView;
import com.qing.guo.decoration.R;
import com.qing.guo.decoration.entity.resp.DataResp;
import com.qing.guo.decoration.entity.resp.ListResp;
import com.qing.guo.decoration.entity.resp.Site;
import com.qing.guo.decoration.entity.resp.SiteDetail;
import com.qing.guo.decoration.retrofit.ResponseListener;
import com.qing.guo.decoration.service.impl.ApiServiceImpl;
import com.qing.guo.decoration.utils.ActivityUtils;
import com.qing.guo.decoration.utils.AppUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dinghu on 2019/7/17.
 */
public class SiteListActivity extends RefreshLoadListViewActivity<Site, SiteListActivity.ViewHolder> {


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
    List<Site> mDatas = new ArrayList<>();


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
        bindView(smartRefreshLayout, list, mDatas);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Site site = mDatas.get(i);
                showLoading();
                ApiServiceImpl.getSiteDetail(site.getId(), new ResponseListener<DataResp<SiteDetail>>() {
                    @Override
                    public void onSuccess(DataResp<SiteDetail> siteDetailDataResp) {
                        hideLoading();
                        Intent intent = new Intent(SiteListActivity.this, SiteDetailActivity.class);
                        intent.putExtra("siteDetail", siteDetailDataResp.data);
                        ActivityUtils.startActivity(SiteListActivity.this, intent);
                    }

                    @Override
                    public void onFail(String code, String message) {
                        hideLoading();
                        ToastUtils.showLong(message);
                    }
                });
            }
        });
    }

    @Override
    public ViewHolder getViewHolder(View convertView) {
        return new ViewHolder(convertView);
    }

    @Override
    public void initializeViews(int position, Site site, ViewHolder viewHolder) {
        viewHolder.title.setText(site.getTitle());
        viewHolder.location.setText(site.getHousename() + " / " + site.getProvince() + site.getCity() + site.getDistrict());
        Glide.with(this).load(AppUtils.getImageUrl(site.getImg())).into(viewHolder.image);
    }

    @Override
    public void getData(int page, boolean isRefreh) {
        Map<String, String> params = new HashMap<>();
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

    @OnClick(R.id.communityLayout)
    public void onViewClicked() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        List<String> allList = new ArrayList<>();
        List<String> xiaoqu1List = new ArrayList<>();
        List<String> xiaoqu2List = new ArrayList<>();
        List<String> xiaoqu3List = new ArrayList<>();
        xiaoqu1List.add("小区1");
        xiaoqu1List.add("小区2");
        xiaoqu1List.add("小区3");

        xiaoqu2List.add("小区4");
        xiaoqu2List.add("小区5");
        xiaoqu2List.add("小区6");

        xiaoqu3List.add("小区7");
        xiaoqu3List.add("小区8");
        allList.add("全部");
        allList.addAll(xiaoqu1List);
        allList.addAll(xiaoqu2List);
        allList.addAll(xiaoqu3List);

        linkedHashMap.put("全部", allList);
        linkedHashMap.put("杨浦区", xiaoqu1List);
        linkedHashMap.put("静安区", xiaoqu2List);
        linkedHashMap.put("朝阳区", xiaoqu3List);
        SecondaryListSelectDialog secondaryListSelectDialog = new SecondaryListSelectDialog(this, linkedHashMap);
        secondaryListSelectDialog.show();
    }

    @OnClick(R.id.styleLayout)
    public void onStyleLayoutClicked() {
        List<String> styles = new ArrayList<>();
        styles.add("风格1");
        styles.add("风格2");
        styles.add("风格3");
        ListSelectDialog<String> listSelectDialog = new ListSelectDialog<>(this, styles, new ListSelectDialog.OnItemSelectListener<String>() {
            @Override
            public void onSelect(String item) {

            }
        });
        listSelectDialog.show();
    }

    @OnClick(R.id.stageLayout)
    public void onStageLayoutClicked() {
        List<String> styles = new ArrayList<>();
        styles.add("阶段1");
        styles.add("阶段2");
        styles.add("阶段3");
        ListSelectDialog<String> listSelectDialog = new ListSelectDialog<>(this, styles, new ListSelectDialog.OnItemSelectListener<String>() {
            @Override
            public void onSelect(String item) {

            }
        });
        listSelectDialog.show();
    }

    @OnClick(R.id.sortLayout)
    public void onSortLayoutClicked() {
        List<String> styles = new ArrayList<>();
        styles.add("施工进度1");
        styles.add("施工进度2");
        styles.add("施工进度3");
        ListSelectDialog<String> listSelectDialog = new ListSelectDialog<>(this, styles, new ListSelectDialog.OnItemSelectListener<String>() {
            @Override
            public void onSelect(String item) {

            }
        });
        listSelectDialog.show();
    }

    static class ViewHolder {
        @BindView(R.id.image)
        RoundedImageView image;
        @BindView(R.id.lable)
        TextView lable;
        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.info)
        TextView info;
        @BindView(R.id.location)
        TextView location;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
