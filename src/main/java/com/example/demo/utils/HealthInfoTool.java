package com.example.demo.utils;

import com.example.demo.entity.Health;

import java.util.ArrayList;

public class HealthInfoTool {
    private int statusCode;// 返回码
    private ArrayList<HealthInfo> data;// 数据源


    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public ArrayList<HealthInfo> getData() {
        return data;
    }

    public void setData(ArrayList<HealthInfo> data) {
        this.data = data;
    }
}
