package com.qing.guo.decoration.ui.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.blankj.utilcode.util.ToastUtils;
import com.fkh.support.ui.activity.BaseActivity;
import com.qing.guo.decoration.R;
import com.qing.guo.decoration.entity.resp.BaseResp;
import com.qing.guo.decoration.retrofit.ResponseListener;
import com.qing.guo.decoration.service.impl.ApiServiceImpl;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dinghu on 2019/7/22.
 */
public class ServiceActivity2 extends BaseServiceActivity {
    @BindView(R.id.roomName)
    EditText roomName;
    @BindView(R.id.roomPhone)
    EditText roomPhone;
    @BindView(R.id.reserveBtn)
    Button reserveBtn;

    @Override
    protected int getLayout() {
        return R.layout.layout_service_free_measuring_room;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected Map<String, String> getParams() {
        Map<String,String> params = new HashMap<>();
        params.put("name",roomName.getText().toString());
        params.put("mobile",roomPhone.getText().toString());
        params.put("type",getType());
        return params;
    }

    @Override
    protected String getType() {
        return "2";
    }

    @OnClick(R.id.reserveBtn)
    public void onViewClicked() {
       saveSubmit();
    }
}
