package com.qing.guo.decoration.ui.activity;

import android.widget.Button;
import android.widget.EditText;

import com.qing.guo.decoration.R;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by dinghu on 2019/7/22.
 */
public class ServiceActivity4 extends BaseServiceActivity {
    @BindView(R.id.salesName)
    EditText salesName;
    @BindView(R.id.salesPhone)
    EditText salesPhone;
    @BindView(R.id.question)
    EditText question;
    @BindView(R.id.serviceBtn)
    Button serviceBtn;

    @Override
    protected int getLayout() {
        return R.layout.layout_service_sales_service;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected Map<String, String> getParams() {
        Map<String, String> params = new HashMap<>();
        params.put("name", salesName.getText().toString());
        params.put("mobile", salesPhone.getText().toString());
        params.put("question", question.getText().toString());
        params.put("type", getType());
        return params;
    }

    @Override
    protected String getType() {
        return "4";
    }

    @OnClick(R.id.serviceBtn)
    public void onViewClicked() {
        saveSubmit();
    }
}
