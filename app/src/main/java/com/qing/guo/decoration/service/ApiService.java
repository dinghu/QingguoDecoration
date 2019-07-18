package com.qing.guo.decoration.service;

import com.qing.guo.decoration.entity.resp.BaseResp;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.POST;

/**
 * Created by dinghu on 2019/7/18.
 */
public interface ApiService {

    @POST("app/offer/save")
    Call<BaseResp> offerSave(@FieldMap Map<String, String> map);
}
