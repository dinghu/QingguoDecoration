package com.qing.guo.decoration.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.fkh.support.ui.activity.BaseActivity;
import com.qing.guo.decoration.R;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by dinghu on 2019/7/22.
 */
public class ServiceActivity3 extends BaseServiceActivity {
    @BindView(R.id.advisoryName)
    EditText advisoryName;
    @BindView(R.id.advisoryPhone)
    EditText advisoryPhone;
    @BindView(R.id.submit)
    Button submit;

    @Override
    protected int getLayout() {
        return R.layout.layout_service_free_advisory;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected Map<String, String> getParams() {
        Map<String,String> params = new HashMap<>();
        params.put("name",advisoryName.getText().toString());
        params.put("mobile",advisoryPhone.getText().toString());
        params.put("type",getType());
        return params;
    }

    @Override
    protected String getType() {
        return "3";
    }

    @OnClick({R.id.advisoryName, R.id.advisoryPhone, R.id.submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.submit:
                saveSubmit();
                break;
        }
    }
}
