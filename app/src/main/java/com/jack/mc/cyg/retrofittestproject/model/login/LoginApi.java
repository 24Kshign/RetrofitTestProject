package com.jack.mc.cyg.retrofittestproject.model.login;

import com.jack.mc.cyg.retrofittestproject.base.BaseApi;
import com.jack.mc.cyg.retrofittestproject.callback.ApiCallback;
import com.jack.mc.cyg.retrofittestproject.callback.RetrofitCallback;
import com.jack.mc.cyg.retrofittestproject.model.GitModel;

import retrofit2.Call;

/**
 *
 */
public class LoginApi extends BaseApi {

    private LoginServletApi mLoginApi;

    @Override
    protected String getUri() {
        return "http://www.imooc.com/api/";
    }

    public LoginApi() {
        mLoginApi = mRetrofit.create(LoginServletApi.class);
    }

    public void execute(ApiCallback<GitModel> callback) {
        Call<GitModel> call = mLoginApi.getLoginData();
        call.enqueue(new RetrofitCallback<GitModel>(callback));
    }
}
