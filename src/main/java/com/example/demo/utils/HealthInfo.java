package com.example.demo.utils;


public class HealthInfo {
    private String healthDate;
    private Float healthTemp;
    private String healthCdt;

    public void setInfo(String healthDate,Float healthTemp,String healthCdt){
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

    public String getHealthCdt() {
        return healthCdt;
    }

    public void setHealthCdt(String healthCdt) {
        this.healthCdt = healthCdt;
    }
}
