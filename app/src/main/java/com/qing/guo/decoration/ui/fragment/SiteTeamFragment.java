package com.qing.guo.decoration.ui.fragment;

import android.view.View;
import android.widget.TextView;

import com.fkh.support.ui.adapter.BaseListAdapter;
import com.fkh.support.ui.fragment.BaseFragment;
import com.fkh.support.ui.widget.ScrollListView;
import com.makeramen.roundedimageview.RoundedImageView;
import com.qing.guo.decoration.R;

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

    private List<Integer> integers = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_site_team;
    }

    @Override
    protected void initView(View view) {
        integers.add(1);
        integers.add(2);
        integers.add(3);
        teamiList.setAdapter(new BaseListAdapter<Integer, ViewHolder>(integers, getContext()) {
            @Override
            public int getItemLayout() {
                return R.layout.item_site_team;
            }

            @Override
            public ViewHolder getViewHolder(View convertView) {
                return new ViewHolder(convertView);
            }

            @Override
            public void initializeViews(int position, Integer integer, ViewHolder viewHolder) {

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
