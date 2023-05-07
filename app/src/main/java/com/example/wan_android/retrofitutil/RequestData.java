package com.example.wan_android.retrofitutil;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.wan_android.newitem.newsbean.Data;
import com.example.wan_android.newitem.newsbean.New_Item;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RequestData  {
    private final MyAPIService myAPIService = RetrofitUtil.getInstance().getAPI();
    private Data data;


    public Data GetNewsData(int Current_Page){
        if (data == null){
            RequestNewsData(Current_Page);
        }
        return data;
    }

    private void RequestNewsData(int CURRENT_PAGE){
        Call<New_Item> call = myAPIService.getNewUrl(CURRENT_PAGE);

        call.enqueue(new Callback<New_Item>() {
            @Override
            public void onResponse(@NonNull Call<New_Item> call, @NonNull Response<New_Item> response) {
                if (response.isSuccessful()) {
                    assert response.body() != null;
                    data = response.body().getData();
                }
            }
            @Override
            public void onFailure(@NonNull Call<New_Item> call, @NonNull Throwable t) {
                Log.e("connectfail", "connectfail");
            }
        });
    }

}
