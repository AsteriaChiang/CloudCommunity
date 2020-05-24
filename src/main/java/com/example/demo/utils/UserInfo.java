package com.example.demo.utils;

public class UserInfo {

    private String tel;
    private String name;
    private String ic;
    private Integer sex;

    public UserInfo(){
    }

    public void setInfo(String tel,String name,String ic,Integer sex){
        this.tel=tel;
        this.name = name;
        this.ic = ic;
        this.sex = sex;
    }


    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIc() {
        return ic;
    }

    public void setIc(String ic) {
        this.ic = ic;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
