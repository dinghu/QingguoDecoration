package com.qing.guo.decoration.ui.activity;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qing.guo.decoration.R;
import com.qing.guo.decoration.base.BaseRefreshLoadListViewActivity;
import com.qing.guo.decoration.entity.resp.House;
import com.qing.guo.decoration.entity.resp.ListResp;
import com.qing.guo.decoration.retrofit.ResponseListener;
import com.qing.guo.decoration.service.impl.ApiServiceImpl;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dinghu on 2019/7/22.
 */
public class HouseListActivity extends BaseRefreshLoadListViewActivity<House, HouseListActivity.ViewHolder> {

    @Override
    protected String getTitleText() {
        return "小区列表";
    }

    @Override
    public ViewHolder getViewHolder(View convertView) {
        return new ViewHolder(convertView);
    }

    @Override
    public int getItemLayout() {
        return R.layout.item_house;
    }

    @Override
    public void initializeViews(int position, House house, ViewHolder viewholder) {
        viewholder.communityOneNameTv.setText(house.houseName);
        viewholder.communityOneCountTv.setText(house.amount);
        viewholder.communityOneAddressTv.setText(house.province + house.city + house.district + house.address);
    }

    @Override
    public void getData(int page, boolean isRefreh) {
        ApiServiceImpl.getHouseList(new ResponseListener<ListResp<House>>() {
            @Override
            public void onSuccess(ListResp<House> houseListResp) {
                dealDataRecive(houseListResp.list, true);
            }

            @Override
            public void onFail(String code, String message) {
                dealError(message);
            }
        });
    }

    static class ViewHolder {
        @BindView(R.id.communityOneNameTv)
        TextView communityOneNameTv;
        @BindView(R.id.communityOneAddressTv)
        TextView communityOneAddressTv;
        @BindView(R.id.communityOneCountTv)
        TextView communityOneCountTv;
        @BindView(R.id.communityOneLayout)
        RelativeLayout communityOneLayout;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
