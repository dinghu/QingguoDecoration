package com.qing.guo.decoration.service;

import com.qing.guo.decoration.entity.req.RongTokenReq;
import com.qing.guo.decoration.entity.resp.RongTokenResp;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by dinghu on 2019/7/22.
 */
public interface ImService {
//    @FormUrlEncoded
//    @POST("user/getToken.json")
//    Call<RongTokenResp> getRongtoken(@Body RongTokenReq rongTokenReq);

    @FormUrlEncoded
    @POST("user/getToken.json")
    Call<RongTokenResp> getRongtoken(@FieldMap Map<String, String> map);
}
