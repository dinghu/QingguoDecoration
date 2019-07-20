package com.qing.guo.decoration.ui.activity;

import android.widget.TextView;

import com.blankj.utilcode.util.AppUtils;
import com.fkh.support.ui.activity.BaseActivity;
import com.qing.guo.decoration.R;

import butterknife.BindView;

public class AboatActivity extends BaseActivity {

    @BindView(R.id.version)
    TextView version;

    @Override
    protected int getLayout() {
        return R.layout.activity_aboat;
    }

    @Override
    protected void initView() {
        version.setText(AppUtils.getAppVersionCode());
    }


}
