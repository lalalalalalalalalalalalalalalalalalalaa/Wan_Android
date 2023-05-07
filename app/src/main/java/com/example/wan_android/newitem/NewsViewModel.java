package com.example.wan_android.newitem;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.wan_android.banner.Banner_item;
import com.example.wan_android.newitem.newsbean.Items;
import com.example.wan_android.newitem.newsbean.New_Item;
import com.example.wan_android.retrofitutil.MyAPIService;
import com.example.wan_android.retrofitutil.RetrofitUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsViewModel extends ViewModel {


    private NewsRepository newsRepository;
    public NewsViewModel(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    private final MutableLiveData<List<Items>> _news = new MutableLiveData<>();
    public LiveData<List<Items>> getNews() {
        return _news;
    }
    private static int CURRENT_PAGE = 0;

    public void addPage(){
        CURRENT_PAGE += 1;
    }

    public static int NEWS_ISLOADING = 0;
    public static int TOTAL_PAGE = 0;

    private List<Banner_item> _banners;



    public void getNewsData(){
        MyAPIService myAPIService = RetrofitUtil.getInstance().getAPI();
        Call<New_Item> call = myAPIService.getNewUrl(CURRENT_PAGE);
        call.enqueue(new Callback<New_Item>() {
            @Override
            public void onResponse(@NonNull Call<New_Item> call, @NonNull Response<New_Item> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    Log.e("connectSucess", response.body().getData().getDatas().toString());
                    assert response.body() != null;
                    List<Items> newsData = response.body().getData().getDatas();
                    TOTAL_PAGE = response.body().getPageCount();
                    _news.setValue(newsData);

                }

            }

            @Override
            public void onFailure(@NonNull Call<New_Item> call, Throwable t) {
                Log.e("connectfail", "connectfail");
            }
        });

    }

    public void getBannerData(){
        MyAPIService myAPIService = RetrofitUtil.getInstance().getAPI();
        Call<List<Banner_item>> call = myAPIService.getBannerUrl();
        call.enqueue(new Callback<List<Banner_item>>() {
            @Override
            public void onResponse(Call<List<Banner_item>> call, Response<List<Banner_item>> response) {
                List<Banner_item> banners =  response.body();
                _banners = banners;
            }

            @Override
            public void onFailure(Call<List<Banner_item>> call, Throwable t) {
                _banners = null;
            }
        });
    }

}