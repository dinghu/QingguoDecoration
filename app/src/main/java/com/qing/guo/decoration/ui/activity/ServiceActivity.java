package com.qing.guo.decoration.ui.activity;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.fkh.support.ui.activity.BaseActivity;
import com.qing.guo.decoration.R;
import com.qing.guo.decoration.entity.resp.BaseResp;
import com.qing.guo.decoration.retrofit.ResponseListener;
import com.qing.guo.decoration.service.impl.ApiServiceImpl;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by dinghu on 2019/7/22.
 */
public class ServiceActivity extends BaseServiceActivity {


    @BindView(R.id.offerName)
    EditText offerName;
    @BindView(R.id.offerPhone)
    EditText offerPhone;
    @BindView(R.id.address)
    EditText address;
    @BindView(R.id.shi)
    EditText shi;
    @BindView(R.id.ting)
    EditText ting;
    @BindView(R.id.chu)
    EditText chu;
    @BindView(R.id.wei)
    TextView wei;
    @BindView(R.id.getPriceBtn)
    Button getPriceBtn;

    @Override
    protected int getLayout() {
        return R.layout.layout_service_decoration_offer;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected Map<String, String> getParams() {
        Map<String,String> params = new HashMap<>();
        params.put("name",offerName.getText().toString());
        params.put("mobile",offerPhone.getText().toString());
        params.put("address",address.getText().toString());
        params.put("shi",shi.getText().toString());
        params.put("ting",ting.getText().toString());
        params.put("chu",chu.getText().toString());
        params.put("type",getType());
        params.put("wei",wei.getText().toString());

        return params;
    }

    @Override
    protected String getType() {
        return "1";
    }



    @OnClick(R.id.getPriceBtn)
    public void onViewClicked() {
        saveSubmit();
    }
}
