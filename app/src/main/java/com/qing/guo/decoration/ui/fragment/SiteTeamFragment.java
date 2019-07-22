package com.qing.guo.decoration.ui.fragment;

import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fkh.support.ui.adapter.BaseListAdapter;
import com.fkh.support.ui.fragment.BaseFragment;
import com.fkh.support.ui.widget.ScrollListView;
import com.makeramen.roundedimageview.RoundedImageView;
import com.qing.guo.decoration.R;
import com.qing.guo.decoration.entity.resp.DataResp;
import com.qing.guo.decoration.entity.resp.OprationteamDetail;
import com.qing.guo.decoration.entity.resp.SiteDetail;
import com.qing.guo.decoration.retrofit.ResponseListener;
import com.qing.guo.decoration.service.impl.ApiServiceImpl;
import com.qing.guo.decoration.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dinghu on 2019/7/20.
 */
public class SiteTeamFragment extends BaseFragment {
    @BindView(R.id.teamiList)
    ScrollListView teamiList;

    SiteDetail siteDetail;

    private List<OprationteamDetail> integers = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_site_team;
    }

    @Override
    protected void initView(final View view) {
        teamiList.setAdapter(new BaseListAdapter<OprationteamDetail, ViewHolder>(integers, getContext()) {
            @Override
            public int getItemLayout() {
                return R.layout.item_site_team;
            }

            @Override
            public ViewHolder getViewHolder(View convertView) {
                return new ViewHolder(convertView);
            }

            @Override
            public void initializeViews(int position, OprationteamDetail oprationteamDetail, ViewHolder viewHolder) {
                viewHolder.name.setText(oprationteamDetail.name);
                viewHolder.role.setText(oprationteamDetail.introduce);
//                Glide.with(this).load(AppUtils.getImageUrl(oprationteamDetail)).into( viewHolder.head);
            }
        });
        getTeam();
    }

    private void getTeam() {
        ApiServiceImpl.getOprationteamDetail(siteDetail.getTeamid(), new ResponseListener<DataResp<OprationteamDetail>>() {
            @Override
            public void onSuccess(DataResp<OprationteamDetail> oprationteamDetailDataResp) {
                integers.add(oprationteamDetailDataResp.data);
            }

            @Override
            public void onFail(String code, String message) {

            }
        });
    }

    class ViewHolder {
        @BindView(R.id.head)
        RoundedImageView head;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.role)
        TextView role;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
