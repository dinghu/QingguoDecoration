package com.qing.guo.decoration.service.impl;

import com.qing.guo.decoration.entity.resp.DataResp;
import com.qing.guo.decoration.entity.resp.House;
import com.qing.guo.decoration.entity.resp.ListResp;
import com.qing.guo.decoration.entity.resp.Product;
import com.qing.guo.decoration.entity.resp.ProductDetail;
import com.qing.guo.decoration.entity.resp.QActivity;
import com.qing.guo.decoration.entity.resp.Site;
import com.qing.guo.decoration.entity.resp.SiteDetail;
import com.qing.guo.decoration.retrofit.ResponseListener;
import com.qing.guo.decoration.retrofit.RetrofitHelper;
import com.qing.guo.decoration.service.ApiService;

import java.util.HashMap;

public class ApiServiceImpl {

    private static ApiService apiService = RetrofitHelper.getApiService();

    public static void getProductList(final ResponseListener<ListResp<Product>> responseListener) {
        RetrofitHelper.sendRequest(apiService.getProductList(), responseListener);
    }

    public static void getProductDetail(String id, final ResponseListener<DataResp<ProductDetail>> responseListener) {
        RetrofitHelper.sendRequest(apiService.getProductDetail(id), responseListener);
    }

    public static void getQActivityList(final ResponseListener<ListResp<QActivity>> responseListener) {
        RetrofitHelper.sendRequest(apiService.getQActivityList(), responseListener);
    }

    public static void getHouseList(final ResponseListener<ListResp<House>> responseListener) {
        RetrofitHelper.sendRequest(apiService.getHouseList(), responseListener);
    }

    public static void getSiteList(final ResponseListener<ListResp<Site>> responseListener) {
        RetrofitHelper.sendRequest(apiService.getSiteList(), responseListener);
    }


    public static void getSiteDetail(String id,final ResponseListener<DataResp<SiteDetail>> responseListener) {
        RetrofitHelper.sendRequest(apiService.getSiteDetail(id), responseListener);
    }
}
