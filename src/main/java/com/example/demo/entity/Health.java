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
    private Date healthDate;
    private Float healthTemp;

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

    public Date getDate() {
        return healthDate;
    }
    public void setDate(Date healthDate) {
        this.healthDate = healthDate;
    }

    public Float getTemp() { return healthTemp; }
    public void setTemp(Float healthTemp) {
        this.healthTemp = healthTemp;
    }

}
