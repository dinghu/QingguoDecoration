package com.qing.guo.decoration.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.blankj.utilcode.util.SPUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.bumptech.glide.Glide;
import com.fkh.support.ui.adapter.BaseListAdapter;
import com.fkh.support.ui.fragment.BaseFragment;
import com.fkh.support.ui.widget.ScrollGirdView;
import com.fkh.support.ui.widget.ScrollListView;
import com.makeramen.roundedimageview.RoundedImageView;
import com.qing.guo.decoration.R;
import com.qing.guo.decoration.entity.req.RongTokenReq;
import com.qing.guo.decoration.entity.resp.CompanyDetail;
import com.qing.guo.decoration.entity.resp.DataResp;
import com.qing.guo.decoration.entity.resp.RongTokenResp;
import com.qing.guo.decoration.retrofit.ResponseListener;
import com.qing.guo.decoration.retrofit.RetrofitHelper;
import com.qing.guo.decoration.service.impl.ApiServiceImpl;
import com.qing.guo.decoration.service.impl.ImServiceImpl;
import com.qing.guo.decoration.ui.activity.ActivityListActivity;
import com.qing.guo.decoration.ui.activity.CaseListActivity;
import com.qing.guo.decoration.ui.activity.CompanyInfoActivity;
import com.qing.guo.decoration.ui.activity.CompanyMembersActivity;
import com.qing.guo.decoration.ui.activity.CompanySetttingActivity;
import com.qing.guo.decoration.ui.activity.HouseListActivity;
import com.qing.guo.decoration.ui.activity.ProductListActivity;
import com.qing.guo.decoration.ui.activity.ServiceActivity;
import com.qing.guo.decoration.ui.activity.ServiceActivity2;
import com.qing.guo.decoration.ui.activity.ServiceActivity3;
import com.qing.guo.decoration.ui.activity.ServiceActivity4;
import com.qing.guo.decoration.ui.activity.ShareQRcodeActivity;
import com.qing.guo.decoration.ui.activity.SiteListActivity;
import com.qing.guo.decoration.ui.activity.WebViewActivity;
import com.qing.guo.decoration.utils.ActivityUtils;
import com.qing.guo.decoration.utils.AppUtils;
import com.qing.guo.decoration.utils.RongUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.UserInfo;

public class HomeFragment extends BaseFragment {

    @BindView(R.id.head)
    RoundedImageView head;
    @BindView(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;
    @BindView(R.id.tuiguangScrollGirdView)
    ScrollGirdView tuiguangScrollGirdView;
    @BindView(R.id.convenientBanner)
    ConvenientBanner convenientBanner;
    @BindView(R.id.dongtaiList)
    ScrollListView dongtaiList;
    @BindView(R.id.nickName)
    TextView nickName;
    List<String> bannerList = new ArrayList<>();
    ArrayList<Integer> tuiguangList = new ArrayList<>();
    CompanyDetail companyDetail;
    @BindView(R.id.company_setting)
    LinearLayout companySetting;
    @BindView(R.id.company_info)
    LinearLayout companyInfo;
    @BindView(R.id.company_members)
    LinearLayout companyMembers;
    @BindView(R.id.company_bindweichat)
    LinearLayout companyBindweichat;
    @BindView(R.id.site)
    LinearLayout site;
    @BindView(R.id.cases)
    LinearLayout cases;
    @BindView(R.id.product)
    LinearLayout product;
    @BindView(R.id.activities)
    LinearLayout activities;
    @BindView(R.id.zhuanxiuprice)
    LinearLayout zhuanxiuprice;
    @BindView(R.id.mianfeiliangfang)
    LinearLayout mianfeiliangfang;
    @BindView(R.id.mianfeizixun)
    LinearLayout mianfeizixun;
    @BindView(R.id.shouhoufuwu)
    LinearLayout shouhoufuwu;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }


    @OnClick({R.id.company_setting, R.id.company_info, R.id.company_members, R.id.company_bindweichat,
            R.id.site, R.id.cases, R.id.product, R.id.activities, R.id.zhuanxiuprice, R.id.mianfeiliangfang
            , R.id.mianfeizixun, R.id.shouhoufuwu})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.company_setting:
                ActivityUtils.startActivity(getContext(), CompanySetttingActivity.class);
                break;
            case R.id.company_info:
                if (companyDetail != null) {
                    Intent intent = new Intent(getContext(), CompanyInfoActivity.class);
                    intent.putExtra("companyDetail", companyDetail);
                    ActivityUtils.startActivity(getContext(), intent);
                }
                break;
            case R.id.company_members:
                ActivityUtils.startActivity(getContext(), CompanyMembersActivity.class);
                break;
            case R.id.company_bindweichat:
//                ActivityUtils.startActivity(getContext(), CompanySetttingActivity.class);
                break;
            case R.id.site:
                ActivityUtils.startActivity(getContext(), SiteListActivity.class);
                break;
            case R.id.cases:
                ActivityUtils.startActivity(getContext(), CaseListActivity.class);
                break;
            case R.id.product:
                ActivityUtils.startActivity(getContext(), ProductListActivity.class);
                break;
            case R.id.activities:
                ActivityUtils.startActivity(getContext(), ActivityListActivity.class);
                break;
            case R.id.zhuanxiuprice:
                ActivityUtils.startActivity(getContext(), ServiceActivity.class);
                break;
            case R.id.mianfeiliangfang:
                ActivityUtils.startActivity(getContext(), ServiceActivity2.class);
                break;
            case R.id.mianfeizixun:
                ActivityUtils.startActivity(getContext(), ServiceActivity3.class);
                break;
            case R.id.shouhoufuwu:
                ActivityUtils.startActivity(getContext(), ServiceActivity4.class);
                break;
        }
    }

    private void getCompanyInfo() {
        ApiServiceImpl.getCompanyDetail("1", new ResponseListener<DataResp<CompanyDetail>>() {
            @Override
            public void onSuccess(DataResp<CompanyDetail> companyDetailDataResp) {
                //ActivityUtils.startActivity(getContext(), CompanyInfoActivity.class);
                companyDetail = companyDetailDataResp.data;
            }

            @Override
            public void onFail(String code, String message) {

            }
        });
    }

    void initData() {
        getCompanyInfo();
    }

    class TuiguangViewholder {
        ImageView imageView;
    }


    @Override
    protected void initView(View view) {
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayout.setRefreshing(false);
                    }
                }, 1000);
            }
        });
        tuiguangList.add(R.drawable.icon_tuiguang_1);
        tuiguangList.add(R.drawable.icon_tuiguang_2);
        tuiguangList.add(R.drawable.icon_tuiguang_3);
        tuiguangList.add(R.drawable.icon_tuiguang_4);
        tuiguangList.add(R.drawable.icon_tuiguang_5);
        tuiguangList.add(R.drawable.icon_tuiguang_6);

        bannerList.add("https://www.kameng98.com/data/upload/youhui/15491609385c5651ea10366.jpg");
        bannerList.add("http://www.vip.wo.tt/images/article/15_content_1559740651543776.jpg");
        bannerList.add("http://image1.quanmama.com/AdminImageUpload/4684M1.png");
        //推广
        tuiguangScrollGirdView.setFocusable(false);
        tuiguangScrollGirdView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (1 == i){
                    ActivityUtils.startActivity(getContext(), HouseListActivity.class);
                }else if (0 == i){
                    ActivityUtils.startActivity(getContext(), ShareQRcodeActivity.class);
                }else {
                    ToastUtils.showLong("功能陆续开放中");
                }
            }
        });
        tuiguangScrollGirdView.setAdapter(new BaseListAdapter<Integer, TuiguangViewholder>(tuiguangList, getContext()) {
            @Override
            public int getItemLayout() {
                return R.layout.item_home_tuiguang;
            }

            @Override
            public TuiguangViewholder getViewHolder(View convertView) {
                TuiguangViewholder tuiguangViewholder = new TuiguangViewholder();
                tuiguangViewholder.imageView = convertView.findViewById(R.id.image);
                return tuiguangViewholder;
            }

            @Override
            public void initializeViews(int position, Integer integer, TuiguangViewholder holder) {
                TuiguangViewholder tuiguangViewholder = (TuiguangViewholder) holder;
                tuiguangViewholder.imageView.setImageResource(integer);
            }
        });
        //banner
        initBanner();

        String userName = SPUtils.getInstance().getString("username");
        if (!TextUtils.isEmpty(userName)) {
            nickName.setText(userName);
        }
        initData();

        //融云初始化
        RongUtils.initRongChat(getContext());
    }

    void initBanner() {
        convenientBanner.setFocusable(false);
        //自定义你的Holder，实现更多复杂的界面，不一定是图片翻页，其他任何控件翻页亦可。
        convenientBanner.setPages(
                new CBViewHolderCreator<LocalImageHolderView>() {
                    @Override
                    public LocalImageHolderView createHolder() {
                        return new LocalImageHolderView();
                    }
                }, bannerList)
                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                .setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused})
                //设置指示器的方向
                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT);
    }

    @Override
    public void onResume() {
        super.onResume();
        //开始自动翻页
        convenientBanner.startTurning(3000);
        convenientBanner.setCanLoop(true);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    public class LocalImageHolderView implements Holder<Object> {
        private ImageView adsImageView;
        private TextView adsTextView;

        @Override
        public View createView(Context context) {
            View adsItemView = LayoutInflater.from(context).inflate(R.layout.item_banner, null);
            adsImageView = adsItemView.findViewById(R.id.ads_image);
            adsTextView = adsItemView.findViewById(R.id.ads_description);
            return adsItemView;
        }

        @Override
        public void UpdateUI(Context context, final int position, Object data) {
            adsImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    WebViewActivity.start(getContext(),"活动详情","https://www.baidu.com");
                }
            });
            Glide.with(getContext()).load((String) data).into(adsImageView);
        }
    }
}
