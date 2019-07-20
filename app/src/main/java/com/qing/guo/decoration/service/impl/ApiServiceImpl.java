package com.qing.guo.decoration.service.impl;

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
import com.qing.guo.decoration.retrofit.ResponseListener;
import com.qing.guo.decoration.retrofit.RetrofitHelper;
import com.qing.guo.decoration.service.ApiService;

import java.util.HashMap;
import java.util.Map;

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


    public static void getSiteDetail(String id, final ResponseListener<DataResp<SiteDetail>> responseListener) {
        RetrofitHelper.sendRequest(apiService.getSiteDetail(id), responseListener);
    }

    public static void getOprationteamList(final ResponseListener<ListResp<Oprationteam>> responseListener) {
        RetrofitHelper.sendRequest(apiService.getOprationteamList(), responseListener);
    }


    public static void getOprationteamDetail(String id, final ResponseListener<DataResp<OprationteamDetail>> responseListener) {
        RetrofitHelper.sendRequest(apiService.getOprationteamDetail(id), responseListener);
    }


    public static void getCompanyDetail(String id, final ResponseListener<DataResp<CompanyDetail>> responseListener) {
        RetrofitHelper.sendRequest(apiService.getCompanyDetail(id), responseListener);
    }

    public static void updateCompanyDetail(String id, Map<String, String> map, final ResponseListener<BaseResp> responseListener) {
        RetrofitHelper.sendRequest(apiService.updateCompanyDetail(id, map), responseListener);
    }

    public static void getOprationdynamicDetail(String id, final ResponseListener<DataResp<OprationdynamicDetail>> responseListener) {
        RetrofitHelper.sendRequest(apiService.getOprationdynamicDetail(id), responseListener);
    }

    public static void getOprationdynamicList(String id, final ResponseListener<ListResp<Oprationdynamic>> responseListener) {
        RetrofitHelper.sendRequest(apiService.getOprationdynamicList(), responseListener);
    }

    public static void saveUser(Map<String, String> map, final ResponseListener<BaseResp> responseListener) {
        RetrofitHelper.sendRequest(apiService.saveUser(map), responseListener);
    }

    public static void offerSave(Map<String, String> map, final ResponseListener<BaseResp> responseListener) {
        RetrofitHelper.sendRequest(apiService.offerSave(map), responseListener);
    }
}
