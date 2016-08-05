package com.jack.mc.cyg.retrofittestproject.api;


import com.jack.mc.cyg.retrofittestproject.model.GitModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GitApi {

    // url="http://www.imooc.com/api/teacher?type=4&num=30"
    @GET("teacher?type=4&num=30")
    Call<GitModel> getData();
}