package com.qing.guo.decoration.ui.fragment;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.fkh.support.ui.fragment.BaseFragment;
import com.fkh.support.ui.widget.CheckView;
import com.fkh.support.ui.widget.KeyValueView;
import com.makeramen.roundedimageview.RoundedImageView;
import com.qing.guo.decoration.R;
import com.qing.guo.decoration.ui.activity.AboatActivity;
import com.qing.guo.decoration.ui.activity.LoginActivity;
import com.qing.guo.decoration.ui.activity.SystemNewsListActivity;
import com.qing.guo.decoration.utils.ActivityUtils;
import com.qing.guo.decoration.utils.AppUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import kr.co.namee.permissiongen.PermissionFail;
import kr.co.namee.permissiongen.PermissionGen;
import kr.co.namee.permissiongen.PermissionSuccess;

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
    @BindView(R.id.loginLay)
    RelativeLayout loginLay;
    @BindView(R.id.mynews)
    KeyValueView mynews;
    @BindView(R.id.ivPreIcon)
    RoundedImageView ivPreIcon;
    @BindView(R.id.checkView1)
    CheckView checkView1;
    @BindView(R.id.ivRightImage)
    ImageView ivRightImage;
    @BindView(R.id.kefuphone)
    KeyValueView kefuphone;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView(View view) {
    }

    private void updateUser() {
        String userName = SPUtils.getInstance().getString("username");
        String userAvatar = SPUtils.getInstance().getString("userAvatar");
        if (!TextUtils.isEmpty(userName)) {
            MineFragment.this.userName.setText(userName);
            Glide.with(this).load(AppUtils.getImageUrl(userAvatar)).into(head);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void reqLogin(Context context) {
        ActivityUtils.startActivity(context, LoginActivity.class);
    }

    @OnClick(R.id.aboat)
    public void onViewClicked() {
        ActivityUtils.startActivity(getContext(), AboatActivity.class);
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUser();
    }

    @OnClick(R.id.loginLay)
    public void onLoginLayClicked() {
        String userName = SPUtils.getInstance().getString("username");
        if (TextUtils.isEmpty(userName)) {
            reqLogin(getContext());
        }
    }

    @OnClick(R.id.mynews)
    public void onMynewsClicked() {
        ActivityUtils.startActivity(getContext(), SystemNewsListActivity.class);
    }

    @OnClick(R.id.kefuphone)
    public void onKefuphoneClicked() {
        PermissionGen.with(this).addRequestCode(100).permissions(Manifest.permission.CALL_PHONE).request();
    }

    @PermissionSuccess(requestCode = 100)
    public void perSucccess() {
        callPhone("12345678910");
    }

    @PermissionFail(requestCode = 100)
    public void perFail() {
        ToastUtils.showLong("无拨打电话权限，无法拨号");
    }

    /**
     * 拨打电话（跳转到拨号界面，用户手动点击拨打）
     *
     * @param phoneNum 电话号码
     */
    public void callPhone(String phoneNum) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        Uri data = Uri.parse("tel:" + phoneNum);
        intent.setData(data);
        startActivity(intent);
    }

}
