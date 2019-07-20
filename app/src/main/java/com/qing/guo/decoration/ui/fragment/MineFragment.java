package com.qing.guo.decoration.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fkh.support.ui.fragment.BaseFragment;
import com.fkh.support.ui.widget.KeyValueView;
import com.makeramen.roundedimageview.RoundedImageView;
import com.qing.guo.decoration.R;
import com.qing.guo.decoration.ui.activity.AboatActivity;
import com.qing.guo.decoration.utils.ActivityUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by dinghu on 2019/7/15.
 */
public class MineFragment extends BaseFragment {
    @BindView(R.id.head)
    RoundedImageView head;
    @BindView(R.id.user_name)
    TextView userName;
    @BindView(R.id.lable)
    TextView lable;
    @BindView(R.id.extends_img)
    ImageView extendsImg;
    @BindView(R.id.aboat)
    KeyValueView aboat;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView(View view) {

    }


    @OnClick(R.id.aboat)
    public void onViewClicked() {
        ActivityUtils.startActivity(getContext(), AboatActivity.class);
    }
}
