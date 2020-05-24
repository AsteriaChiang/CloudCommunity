package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Health {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String userTel;
    private String healthDate;
    private Float healthTemp;
    private Integer healthCdt;

    public Health(){

    }

    public Integer getId() {
        return userId;
    }
    public void setId(Integer id) {
        this.userId = id;
    }

    public String getTel() {
        return userTel;
    }
    public void setTel(String userTel) {
        this.userTel = userTel;
    }

    public String getDate() {
        return healthDate;
    }
    public void setDate(String healthDate) {
        this.healthDate = healthDate;
    }

    public Float getTemp() { return healthTemp; }
    public void setTemp(Float healthTemp) {
        this.healthTemp = healthTemp;
    }


    public Integer getHealthCdt() {
        return healthCdt;
    }

    public void setHealthCdt(Integer healthCdt) {
        this.healthCdt = healthCdt;
    }
}
