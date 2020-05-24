package com.example.demo.utils;


public class HealthInfo {
    private String healthDate;
    private Float healthTemp;
    private Integer healthCdt;

    public void setInfo(String healthDate,Float healthTemp,Integer healthCdt){
        this.healthDate = healthDate;
        this.healthTemp = healthTemp;
        this.healthCdt = healthCdt;
    }


    public String getHealthDate() {
        return healthDate;
    }

    public void setHealthDate(String healthDate) {
        this.healthDate = healthDate;
    }

    public Float getHealthTemp() {
        return healthTemp;
    }

    public void setHealthTemp(Float healthTemp) {
        this.healthTemp = healthTemp;
    }


    public Integer getHealthCdt() {
        return healthCdt;
    }

    public void setHealthCdt(Integer healthCdt) {
        this.healthCdt = healthCdt;
    }
}
