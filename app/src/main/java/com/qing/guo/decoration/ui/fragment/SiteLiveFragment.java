package com.qing.guo.decoration.ui.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.blankj.utilcode.util.ToastUtils;
import com.fkh.support.ui.adapter.BaseListAdapter;
import com.fkh.support.ui.fragment.BaseFragment;
import com.fkh.support.ui.widget.ScrollListView;
import com.makeramen.roundedimageview.RoundedImageView;
import com.qing.guo.decoration.R;
import com.qing.guo.decoration.entity.resp.DataResp;
import com.qing.guo.decoration.entity.resp.ListResp;
import com.qing.guo.decoration.entity.resp.Oprationdynamic;
import com.qing.guo.decoration.entity.resp.OprationdynamicDetail;
import com.qing.guo.decoration.entity.resp.SiteDetail;
import com.qing.guo.decoration.retrofit.ResponseListener;
import com.qing.guo.decoration.service.impl.ApiServiceImpl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dinghu on 2019/7/20.
 */
public class SiteLiveFragment extends BaseFragment {
    @BindView(R.id.dongtaiList)
    ScrollListView dongtaiList;
    SiteDetail siteDetail;
    BaseListAdapter adapter;

    public void setSiteDetail(SiteDetail siteDetail) {
        this.siteDetail = siteDetail;
    }

    private List<Oprationdynamic> oprationdynamics = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_site_live;
    }


    @Override
    protected void initView(View view) {
        adapter = new BaseListAdapter<Oprationdynamic, ViewHolder>(oprationdynamics, getContext()) {
            @Override
            public int getItemLayout() {
                return R.layout.item_site_dongtai;
            }

            @Override
            public ViewHolder getViewHolder(View convertView) {
                return new ViewHolder(convertView);
            }

            @Override
            public void initializeViews(int position, Oprationdynamic integer, ViewHolder viewHolder) {

            }
        };
        dongtaiList.setAdapter(adapter);
        getSiteDongtai();
    }

    void getSiteDongtai() {
        ApiServiceImpl.getOprationdynamicList(siteDetail.getId(), new ResponseListener<ListResp<Oprationdynamic>>() {
            @Override
            public void onSuccess(ListResp<Oprationdynamic> oprationdynamicDetailListResp) {
                oprationdynamics.clear();
                oprationdynamics.addAll(oprationdynamicDetailListResp.list);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFail(String code, String message) {
                ToastUtils.showLong(message);
            }
        });
    }

    static class ViewHolder {
        @BindView(R.id.head)
        RoundedImageView head;
        @BindView(R.id.photo1)
        ImageView photo1;
        @BindView(R.id.photo2)
        ImageView photo2;
        @BindView(R.id.photo3)
        ImageView photo3;
        @BindView(R.id.photo4)
        ImageView photo4;
        @BindView(R.id.photo5)
        ImageView photo5;
        @BindView(R.id.photo6)
        ImageView photo6;
        @BindView(R.id.photo7)
        ImageView photo7;
        @BindView(R.id.photo8)
        ImageView photo8;
        @BindView(R.id.photo9)
        ImageView photo9;
        @BindView(R.id.photo_lay)
        LinearLayout photoLay;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
