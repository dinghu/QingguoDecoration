package com.qing.guo.decoration;

import android.support.v4.app.Fragment;

import com.fkh.support.ui.activity.HomeActivity;
import com.fkh.support.ui.widget.NoScrollViewPager;
import com.fkh.support.ui.widget.alphatab.AlphaTabsLayout;
import com.qing.guo.decoration.ui.fragment.HomeFragment;
import com.qing.guo.decoration.ui.fragment.MineFragment;

import java.util.ArrayList;

import butterknife.BindView;

public class MainActivity extends HomeActivity {
    @BindView(R.id.alphaIndicator)
    AlphaTabsLayout alphaIndicator;
    @BindView(R.id.viewPager)
    NoScrollViewPager viewPager;
    ArrayList<Fragment> fragments = new ArrayList<>();

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        mAlphaIndicator = MainActivity.this.alphaIndicator;
        mViewPager = viewPager;
        fragments.add(new HomeFragment());
        fragments.add(new HomeFragment());
        fragments.add(new HomeFragment());
        fragments.add(new MineFragment());
        bindFragement(fragments);
    }


}
