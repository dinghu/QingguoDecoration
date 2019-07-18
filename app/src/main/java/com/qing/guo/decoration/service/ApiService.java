package com.qing.guo.decoration.service;

import com.qing.guo.decoration.entity.resp.BaseResp;
import com.qing.guo.decoration.entity.resp.DataResp;
import com.qing.guo.decoration.entity.resp.ListResp;
import com.qing.guo.decoration.entity.resp.Product;
import com.qing.guo.decoration.entity.resp.ProductDetail;
import com.qing.guo.decoration.entity.resp.QActivity;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by dinghu on 2019/7/18.
 */
public interface ApiService {

    @POST("app/offer/save")
    Call<BaseResp> offerSave(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("app/product/list")
    Call<ListResp<Product>> getProductList();

    @POST("app/product/get")
    Call<DataResp<ProductDetail>> getProductDetail(@Query("id")Integer id);

    @POST("app/activity/list")
    Call<ListResp<QActivity>> getQActivityList();
}
