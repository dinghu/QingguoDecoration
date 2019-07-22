package com.qing.guo.decoration.ui.activity.chat;

import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.makeramen.roundedimageview.RoundedImageView;
import com.qing.guo.decoration.R;
import com.qing.guo.decoration.base.BaseRefreshLoadListViewActivity;
import com.qing.guo.decoration.entity.User;
import com.qing.guo.decoration.utils.AppUtils;
import com.qing.guo.decoration.utils.RongUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.rong.imkit.RongIM;

/**
 * Created by dinghu on 2019/7/22.
 */
public class ChatContractActivity extends BaseRefreshLoadListViewActivity<User, ChatContractActivity.ViewHolder> {

//    private ArrayList<User> users = new ArrayList<>();

    @Override
    protected String getTitleText() {
        return "通讯录";
    }

    @Override
    public ChatContractActivity.ViewHolder getViewHolder(View convertView) {
        return new ChatContractActivity.ViewHolder(convertView);
    }

    @Override
    protected void initView() {
        User user = RongUtils.getSupportUser();
        mDatas.add(user);
        super.initView();
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                User user = mDatas.get(i);
                RongIM.getInstance().startPrivateChat(ChatContractActivity.this, user.userId, user.name);
            }
        });
    }

    @Override
    public int getItemLayout() {
        return R.layout.item_chat_user;
    }

    @Override
    public void initializeViews(int position, User o, ChatContractActivity.ViewHolder o2) {
        o2.username.setText(o.name);
        if (!TextUtils.isEmpty(o.portraitUri)) {
            Glide.with(this).load(AppUtils.getImageUrl(o.portraitUri)).into(o2.avatar);
        }

    }

    @Override
    public void getData(int page, boolean isRefreh) {
        swipeRefreshLayout.finishRefresh();
    }

    static class ViewHolder {
        @BindView(R.id.avatar)
        RoundedImageView avatar;
        @BindView(R.id.username)
        TextView username;
        @BindView(R.id.simple_desc)
        TextView simpleDesc;
        @BindView(R.id.follow_bg)
        RelativeLayout followBg;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
