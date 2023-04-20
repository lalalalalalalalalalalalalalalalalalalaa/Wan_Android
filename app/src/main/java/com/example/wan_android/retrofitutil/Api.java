package com.example.wan_android.retrofitutil;

public class Api {
    static final String baseUrl = "https://www.wanandroid.com/";
//  基本的Url
    static final String newsUrl = "article/list";
//  最新文章
    static final String bannerUrl = "banner/json";
//  廣告板
    static final String otherSource = "friend/json";
//    其他相關的網站資源
    static final String Categories = "tree/json";
//    分類項的標題
    static final String CategoriesDetail = "article/list/0/json?cid=";
//    分類項的細項(id要從上面的標題api取得)




}
