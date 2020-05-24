package com.example.demo.utils;

import com.example.demo.entity.User;
import java.util.ArrayList;

public class UserInfoTool {

    private int statusCode;// 返回码
    private UserInfo data;// 数据源

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }


    public UserInfo getData() {
        return data;
    }

    public void setData(UserInfo data) {
        this.data = data;
    }
}
