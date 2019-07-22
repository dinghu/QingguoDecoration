package com.qing.guo.decoration.service;

import com.qing.guo.decoration.entity.resp.BaseResp;
import com.qing.guo.decoration.entity.resp.CompanyDetail;
import com.qing.guo.decoration.entity.resp.DataResp;
import com.qing.guo.decoration.entity.resp.House;
import com.qing.guo.decoration.entity.resp.ListResp;
import com.qing.guo.decoration.entity.resp.Oprationdynamic;
import com.qing.guo.decoration.entity.resp.OprationdynamicDetail;
import com.qing.guo.decoration.entity.resp.Oprationteam;
import com.qing.guo.decoration.entity.resp.OprationteamDetail;
import com.qing.guo.decoration.entity.resp.Product;
import com.qing.guo.decoration.entity.resp.ProductDetail;
import com.qing.guo.decoration.entity.resp.QActivity;
import com.qing.guo.decoration.entity.resp.Site;
import com.qing.guo.decoration.entity.resp.SiteDetail;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by dinghu on 2019/7/18.
 */
public interface ApiService {

    @FormUrlEncoded
    @POST("app/offer/save")
    Call<BaseResp> offerSave(@FieldMap Map<String, String> map);

    @POST("app/product/list")
    Call<ListResp<Product>> getProductList();

    @POST("app/product/get")
    Call<DataResp<ProductDetail>> getProductDetail(@Query("id") String id);

    @POST("app/activity/list")
    Call<ListResp<QActivity>> getQActivityList();

    @POST("app/house/list")
    Call<ListResp<House>> getHouseList();

    @POST("app/opration/list")
    Call<ListResp<Site>> getSiteList();

    @POST("app/opration/get")
    Call<DataResp<SiteDetail>> getSiteDetail(@Query("id") String id);

    @POST("app/oprationteam/list")
    Call<ListResp<Oprationteam>> getOprationteamList();

    @POST("app/oprationteam/get")
    Call<DataResp<OprationteamDetail>> getOprationteamDetail(@Query("id") String id);

    @POST("app/company/get")
    Call<DataResp<CompanyDetail>> getCompanyDetail(@Query("id") String id);

    @FormUrlEncoded
    @POST("app/company/update")
    Call<BaseResp> updateCompanyDetail(@Query("id") String id, @FieldMap Map<String, String> map);

    @POST("app/oprationdynamic/get")
    Call<DataResp<OprationdynamicDetail>> getOprationdynamicDetail(@Query("id") String id);

    @POST("app/oprationdynamic/list")
    Call<ListResp<Oprationdynamic>> getOprationdynamicList();

    @FormUrlEncoded
    @POST("app/user/save")
    Call<BaseResp> saveUser(@FieldMap Map<String, String> map);
}
