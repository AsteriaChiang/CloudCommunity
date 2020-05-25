package com.example.demo.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String tel;
    private String password;
    private String name;
    private Integer sex;
    private String ic;
    private Integer auz;

    public User(){

    }

    public User(Integer id, String pwd) {
        this.id = id;
        this.password = pwd;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() { return sex; }
    public void setSex(Integer sex) {
        this.sex = sex;
    }


    public String getIc() {
        return ic;
    }
    public void setIc(String ic) {
        this.ic = ic;
    }

    public Integer getAuz() {
        return auz;
    }

    public void setAuz(Integer auz) {
        this.auz = auz;
    }
}
