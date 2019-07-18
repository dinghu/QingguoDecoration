package com.qing.guo.decoration.service.impl;

import com.qing.guo.decoration.entity.resp.DataResp;
import com.qing.guo.decoration.entity.resp.ListResp;
import com.qing.guo.decoration.entity.resp.Product;
import com.qing.guo.decoration.entity.resp.ProductDetail;
import com.qing.guo.decoration.entity.resp.QActivity;
import com.qing.guo.decoration.retrofit.ResponseListener;
import com.qing.guo.decoration.retrofit.RetrofitHelper;
import com.qing.guo.decoration.service.ApiService;

import java.util.HashMap;

public class ApiServiceImpl {

    private static ApiService apiService = RetrofitHelper.getApiService();

    public static void getProductList(final ResponseListener<ListResp<Product>> responseListener) {
        RetrofitHelper.sendRequest(apiService.getProductList(), responseListener);
    }

    public static void getProductDetail(Integer id, final ResponseListener<DataResp<ProductDetail>> responseListener) {
        RetrofitHelper.sendRequest(apiService.getProductDetail(id), responseListener);
    }

    public static void getQActivityList(final ResponseListener<ListResp<QActivity>> responseListener) {
        RetrofitHelper.sendRequest(apiService.getQActivityList(), responseListener);
    }
}
