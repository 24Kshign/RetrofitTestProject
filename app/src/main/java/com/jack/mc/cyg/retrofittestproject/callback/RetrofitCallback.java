package com.jack.mc.cyg.retrofittestproject.callback;

import android.util.Log;

import com.jack.mc.cyg.retrofittestproject.base.BaseRetData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 处理retrofit回调 并调用ApiCallback相应返回
 */
public class RetrofitCallback<T> implements Callback<T> {

    private ApiCallback<T> mCallback;

    public RetrofitCallback(ApiCallback<T> callback) {
        mCallback = callback;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            if (((BaseRetData) response.body()).status == 1) {
                mCallback.onSuccess(response.body());
            } else {
                mCallback.onError(((BaseRetData) response.body()).status, ((BaseRetData) response.body()).msg);
            }
        } else {
            mCallback.onFailure();
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        Log.e("failure", "api failure,throw=" + t.getMessage());
        t.printStackTrace();
        mCallback.onFailure();
    }
}
