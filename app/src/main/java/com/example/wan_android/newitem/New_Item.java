package com.example.wan_android.newitem;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class New_Item {
    private Data data;
    private int pageCount;
    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public int getPageCount() {
        return pageCount;
    }

}

class Data{
    public Data(List<Items> datas, int curpage) {
        this.datas = datas;
        this.curpage = curpage;
    }

    public List<Items> getDatas() {
        return datas;
    }

    public void setDatas(List<Items> datas) {
        this.datas = datas;
    }

    private List<Items> datas;
    private int curpage;
}

class Items {
    private String chapterName;
    private String link;
    private String title;
    private String niceDate;
    private int id;

    public Items(String chapterName, String link, String title, String niceDate, int id) {
        this.chapterName = chapterName;
        this.link = link;
        this.title = title;
        this.niceDate = niceDate;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNiceDate() {
        return niceDate;
    }

    public void setNiceDate(String niceDate) {
        this.niceDate = niceDate;
    }
}




