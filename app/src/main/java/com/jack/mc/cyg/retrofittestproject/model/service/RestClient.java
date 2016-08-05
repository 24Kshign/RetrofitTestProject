package com.jack.mc.cyg.retrofittestproject.model.service;

import com.jack.mc.cyg.retrofittestproject.api.GitApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 */
public class RestClient {
    private static final String BASE_URL = "http://www.imooc.com/api/";
    private GitApi gitApi;

    public RestClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        gitApi = retrofit.create(GitApi.class);
    }

    public GitApi getDataService() {
        return gitApi;
    }
}
