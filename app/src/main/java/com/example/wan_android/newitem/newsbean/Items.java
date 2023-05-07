package com.example.wan_android.newitem.newsbean;

public class Items {
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
