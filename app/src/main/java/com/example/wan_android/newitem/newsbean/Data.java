package com.example.wan_android.newitem.newsbean;

import java.util.List;

public class Data {
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
