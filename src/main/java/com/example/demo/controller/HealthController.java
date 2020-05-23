package com.example.demo.controller;

import com.example.demo.entity.Health;
import com.example.demo.entity.User;
import com.example.demo.service.HealthService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value="/health")
public class HealthController {

    @Autowired
    private UserService userService;
    @Autowired
    private HealthService healthService;
    private Health health = new Health();
    private User user=new User();

    @RequestMapping(value = "/report")
    public Integer healthReport(HttpServletRequest request) throws ParseException {
        Integer healthValue=0;

        String userTel =request.getParameter("tel");
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String healthDate = format.format(date);

        Float healthTemp=(float)0.0;
        if(request.getParameter("temp")!=null){
            healthTemp= Float.parseFloat(request.getParameter("temp"));}
        String healthCdt=request.getParameter("cdt");

        //判断user是否存在
        user = userService.findByUserTel(userTel);
        if(user==null){
            return healthValue;
        }

        health=healthService.findByUserTelAndDate(userTel,healthDate);
        if(health==null){
            Health newhealth = new Health();
            newhealth.setTel(userTel);
            newhealth.setDate(healthDate);
            newhealth.setTemp(healthTemp);
            newhealth.setCdt(healthCdt);
            healthService.save(newhealth);
            healthValue=1;//上报成功
        }else{
            health.setTel(userTel);
            health.setDate(healthDate);
            health.setTemp(healthTemp);
            health.setCdt(healthCdt);
            healthService.update(health);
            healthValue=2;//更新成功
        }


        return healthValue;
    }

    @RequestMapping(value = "/query")
    public Integer query(HttpServletRequest request){
        Integer test=0;
        List<String> healthList=new ArrayList<>();
        String userTel =request.getParameter("tel");

        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String healthDate = format.format(date);
//        health=healthService.findByUserTel (userTel);
        List<Health> healths= new ArrayList<Health>();
        healths=healthService.findTest(userTel);

        if(healths!=null){
//            healthList.add(user.getName());
//            healthList.add(user.getIc());
//            healthList.add(health.getTemp().toString());
//            healthList.add(health.getCdt());
            Health newhealth=healths.get(0);

            System.out.println(newhealth.getCdt());
            test=1;

        }
        else {
            healthList.add(null);
        }

        return test;
    }
}
