package com.qing.guo.decoration.retrofit;

public abstract class ResponseListener<T> {
    public abstract void onSuccess(T t);
    public abstract void onFail(String code,String message);
}
