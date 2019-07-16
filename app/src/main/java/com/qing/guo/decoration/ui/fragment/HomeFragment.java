package com.qing.guo.decoration.ui.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bumptech.glide.Glide;
import com.fkh.support.ui.adapter.BaseListAdapter;
import com.fkh.support.ui.fragment.BaseFragment;
import com.fkh.support.ui.widget.ScrollGirdView;
import com.fkh.support.ui.widget.ScrollListView;
import com.makeramen.roundedimageview.RoundedImageView;
import com.qing.guo.decoration.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

public class HomeFragment extends BaseFragment {

    @BindView(R.id.head)
    RoundedImageView head;
    @BindView(R.id.tuiguangScrollGirdView)
    ScrollGirdView tuiguangScrollGirdView;
    @BindView(R.id.convenientBanner)
    ConvenientBanner convenientBanner;
    @BindView(R.id.dongtaiList)
    ScrollListView dongtaiList;
    Unbinder unbinder;
    List<String> bannerList = new ArrayList<>();
    ArrayList<Integer> tuiguangList = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    class TuiguangViewholder {
        ImageView imageView;
    }

    @Override
    protected void initView(View view) {
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
        tuiguangScrollGirdView.setAdapter(new BaseListAdapter<Integer,TuiguangViewholder>(tuiguangList, getContext()) {
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

            Glide.with(getContext()).load((String) data).into(adsImageView);
        }
    }
}
