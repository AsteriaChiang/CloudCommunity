package com.example.demo.utils;


public class NewsInfo {
    private String newsTitle;
    private String newsContent;

    public void setInfo(String newsTitle,String newsContent){
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }
}
