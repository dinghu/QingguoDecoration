package com.qing.guo.decoration.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fkh.support.ui.activity.BaseActivity;
import com.fkh.support.ui.activity.HomeActivity;
import com.fkh.support.ui.widget.NoScrollViewPager;
import com.qing.guo.decoration.R;
import com.qing.guo.decoration.adapter.CommonFragmentPagerAdapter;
import com.qing.guo.decoration.entity.resp.SiteDetail;
import com.qing.guo.decoration.ui.fragment.ChatFragment;
import com.qing.guo.decoration.ui.fragment.DataFragment;
import com.qing.guo.decoration.ui.fragment.HomeFragment;
import com.qing.guo.decoration.ui.fragment.MineFragment;
import com.qing.guo.decoration.ui.fragment.SiteCommentFragment;
import com.qing.guo.decoration.ui.fragment.SiteLiveFragment;
import com.qing.guo.decoration.ui.fragment.SiteProductFragment;
import com.qing.guo.decoration.ui.fragment.SiteTeamFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SiteDetailActivity extends BaseActivity {
    @BindView(R.id.scan_num)
    TextView scanNum;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.location)
    TextView location;
    @BindView(R.id.info)
    TextView info;
    @BindView(R.id.zhibo)
    TextView zhibo;
    @BindView(R.id.zhiboLine)
    View zhiboLine;
    @BindView(R.id.zhiboLay)
    LinearLayout zhiboLay;
    @BindView(R.id.team)
    TextView team;
    @BindView(R.id.teamLine)
    View teamLine;
    @BindView(R.id.teamLay)
    LinearLayout teamLay;
    @BindView(R.id.product)
    TextView product;
    @BindView(R.id.productLine)
    View productLine;
    @BindView(R.id.productLay)
    LinearLayout productLay;
    @BindView(R.id.comment)
    TextView comment;
    @BindView(R.id.commentLine)
    View commentLine;
    @BindView(R.id.commenttLay)
    LinearLayout commenttLay;
    @BindView(R.id.siteContent)
    FrameLayout siteContent;
    ArrayList<Fragment> fragments = new ArrayList<>();
    int replaceId;

    @Override
    protected int getLayout() {
        return R.layout.activity_site_detail;
    }

    @Override
    protected void initView() {
        SiteDetail siteDetail = (SiteDetail) getIntent().getSerializableExtra("siteDetail");
        SiteLiveFragment siteLiveFragment = new SiteLiveFragment();
        siteLiveFragment.setSiteDetail(siteDetail);
        fragments.add(siteLiveFragment);
        fragments.add(new SiteTeamFragment());
        fragments.add(new SiteProductFragment());
        fragments.add(new SiteCommentFragment());
        replaceId = R.id.siteContent;
        showFragement(0);
    }

    public void setitle(int index) {
        zhiboLine.setVisibility(index == 0 ? View.VISIBLE : View.INVISIBLE);
        teamLine.setVisibility(index == 1 ? View.VISIBLE : View.INVISIBLE);
        productLine.setVisibility(index == 2 ? View.VISIBLE : View.INVISIBLE);
        commentLine.setVisibility(index == 3 ? View.VISIBLE : View.INVISIBLE);
        zhibo.setTextColor(index == 0 ? getResources().getColor(R.color.colorTheme) : getResources().getColor(R.color.color_text_gray));
        team.setTextColor(index == 1 ? getResources().getColor(R.color.colorTheme) : getResources().getColor(R.color.color_text_gray));
        product.setTextColor(index == 2 ? getResources().getColor(R.color.colorTheme) : getResources().getColor(R.color.color_text_gray));
        comment.setTextColor(index == 3 ? getResources().getColor(R.color.colorTheme) : getResources().getColor(R.color.color_text_gray));
    }

    int currentIndex = -1;

    public void showFragement(int index) {
        try {
            if (currentIndex == index) {
                return;
            }
            currentIndex = index;

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();//Fragment中
            Fragment f = fragments.get(index);
            if (f.isAdded()) {
                transaction.show(f);
            } else {
                transaction.add(replaceId, f);
            }
            for (int i = 0; i < fragments.size(); i++) {
                Fragment fragement = fragments.get(i);
                if (fragement != null && fragement.isAdded() && (i != index)) {
                    transaction.hide(fragement);
                }
            }
            transaction.commitAllowingStateLoss();
            setitle(index);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @OnClick({R.id.zhiboLay, R.id.teamLay, R.id.productLay, R.id.commenttLay})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.zhiboLay:
                showFragement(0);
                break;
            case R.id.teamLay:
                showFragement(1);
                break;
            case R.id.productLay:
                showFragement(2);
                break;
            case R.id.commenttLay:
                showFragement(3);
                break;
        }
    }
}
