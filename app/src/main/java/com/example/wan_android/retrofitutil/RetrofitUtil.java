package com.example.wan_android.retrofitutil;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {

    private static RetrofitUtil Instance = new RetrofitUtil();

    private MyAPIService myAPIService;

    private RetrofitUtil(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        myAPIService = retrofit.create(MyAPIService.class);

    }

    public static RetrofitUtil getInstance() {

        return Instance;
    }

    public MyAPIService getAPI(){
        return myAPIService;
    }

}
