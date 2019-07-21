package com.qing.guo.decoration.ui.activity;

import android.os.Bundle;

import com.fkh.support.ui.activity.BaseActivity;
import com.fkh.support.ui.widget.KeyValueView;
import com.qing.guo.decoration.R;
import com.qing.guo.decoration.entity.resp.CompanyDetail;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by dinghu on 2019/7/16.
 */
public class CompanyInfoActivity extends BaseActivity {

//    public String logo;//	String
//    public String name;//	String
//    public String shortname;//String
//    public String mobile;//	String
//    public String address;//	String
//    public String slogan;//	String
//    public String brief;//	String
//    public String qualification;//String
//    public String show;//String

    CompanyDetail companyDetail;
    @BindView(R.id.shortname)
    KeyValueView shortname;
    @BindView(R.id.phone)
    KeyValueView phone;
    @BindView(R.id.address)
    KeyValueView address;
    @BindView(R.id.slogan)
    KeyValueView slogan;
    @BindView(R.id.brief)
    KeyValueView brief;
    @BindView(R.id.qualification)
    KeyValueView qualification;
    @BindView(R.id.show)
    KeyValueView show;

    @Override
    protected int getLayout() {
        return R.layout.activity_company_info;
    }

    @Override
    protected void initView() {
        companyDetail = (CompanyDetail) getIntent().getSerializableExtra("companyDetail");
        shortname.setValue(companyDetail.shortname);
        phone.setValue(companyDetail.mobile);
        address.setValue(companyDetail.address);
        slogan.setValue(companyDetail.slogan);
        brief.setValue(companyDetail.brief);

    }
}
