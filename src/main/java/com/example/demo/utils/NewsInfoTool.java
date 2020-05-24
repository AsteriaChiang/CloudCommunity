package com.example.demo.utils;

public class NewsInfoTool {
    private int statusCode;// 返回码
    private NewsInfo data;

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public NewsInfo getData() {
        return data;
    }

    public void setData(NewsInfo data) {
        this.data = data;
    }
}
