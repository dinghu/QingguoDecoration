package com.qing.guo.decoration.ui.activity;

import com.blankj.utilcode.util.ToastUtils;
import com.fkh.support.ui.activity.BaseActivity;
import com.qing.guo.decoration.entity.resp.BaseResp;
import com.qing.guo.decoration.retrofit.ResponseListener;
import com.qing.guo.decoration.service.impl.ApiServiceImpl;

import java.util.Map;

/**
 * Created by dinghu on 2019/7/22.
 */
public abstract class BaseServiceActivity extends BaseActivity {
    protected abstract Map<String, String> getParams();

    protected abstract String getType();

    public void saveSubmit(){
        ApiServiceImpl.offerSave(getParams(), new ResponseListener<BaseResp>() {
            @Override
            public void onSuccess(BaseResp baseResp) {
                ToastUtils.showLong("提交成功");
                finish();
            }

            @Override
            public void onFail(String code, String message) {
                ToastUtils.showLong(message);
            }
        });
    }
}
