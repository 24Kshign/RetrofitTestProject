package com.jack.mc.cyg.retrofittestproject.callback;

/**
 *
 */
public interface ApiCallback<T> {
    void onSuccess(T data);        //ret=1时返回

    void onError(int status, String msg);   //ret=0时返回

    void onFailure();   //网络请求失败
}