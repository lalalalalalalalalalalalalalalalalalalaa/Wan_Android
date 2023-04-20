package com.example.wan_android.retrofitutil;

import com.example.wan_android.banner.Banner_item;
import com.example.wan_android.newitem.New_Item;
import com.example.wan_android.newitem.News_cell;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MyAPIService {


    @GET(Api.newsUrl + "/{page}/json")
    Call<New_Item> getNewUrl(@Path("page") int page);

    @GET(Api.bannerUrl)
    Call<List<Banner_item>> getBannerUrl();

    @GET(Api.newsUrl + "/0/json")
    Call<List<News_cell>> getnews();





}



