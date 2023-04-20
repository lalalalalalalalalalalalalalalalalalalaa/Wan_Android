package com.example.wan_android.newitem;

public class News_cell {

    public News_cell(String chapterName, String link, String title, String niceDate, int id) {
        this.chapterName = chapterName;
        this.link = link;
        this.title = title;
        this.niceDate = niceDate;
        this.id = id;
    }

    private String chapterName;
    private String link;
    private String title;
    private String niceDate;
    private int id;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
