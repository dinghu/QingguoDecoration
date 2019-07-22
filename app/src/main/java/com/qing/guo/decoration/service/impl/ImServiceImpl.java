package com.qing.guo.decoration.service.impl;

import com.qing.guo.decoration.entity.req.RongTokenReq;
import com.qing.guo.decoration.entity.resp.RongTokenResp;
import com.qing.guo.decoration.retrofit.ResponseListener;
import com.qing.guo.decoration.retrofit.RetrofitHelper;
import com.qing.guo.decoration.service.ImService;

import java.util.Map;

/**
 * Created by dinghu on 2019/7/22.
 */
public class ImServiceImpl {
    private static ImService imService = RetrofitHelper.getImService();
    public static void getRongtoken(Map<String, String> map, final ResponseListener<RongTokenResp> responseListener) {
        RetrofitHelper.sendRequest(imService.getRongtoken(map), responseListener);
    }
}
