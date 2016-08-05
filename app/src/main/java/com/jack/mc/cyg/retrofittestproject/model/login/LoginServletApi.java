package com.jack.mc.cyg.retrofittestproject.model.login;

import com.jack.mc.cyg.retrofittestproject.model.GitModel;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 *
 */
public interface LoginServletApi {

    @POST("teacher?type=4&num=30")
    Call<GitModel> getLoginData();

}