package com.example.demo.controller;

import com.example.demo.entity.Health;
import com.example.demo.entity.User;
import com.example.demo.service.HealthService;
import com.example.demo.service.UserService;
import com.example.demo.utils.HealthInfo;
import com.example.demo.utils.HealthInfoTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    public HealthInfoTool healthReport(HttpServletRequest request) throws ParseException {
        HealthInfoTool reportresult=new HealthInfoTool();
        Integer healthValue=0;

        String userTel =request.getParameter("tel");
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String healthDate = format.format(date);

        Float healthTemp=(float)0.0;
        if(request.getParameter("temp")!=null){
            healthTemp= Float.parseFloat(request.getParameter("temp"));}
        Integer healthCdt=0;
        if(request.getParameter("cdt")!=null){
            healthCdt= Integer.parseInt(request.getParameter("cdt"));}


        //判断user是否存在
        user = userService.findByUserTel(userTel);
        if(user==null){
            reportresult.setStatusCode(healthValue);
            return reportresult;
        }

        health=healthService.findByUserTelAndDate(userTel,healthDate);
        if(health==null){
            Health newhealth = new Health();
            newhealth.setTel(userTel);
            newhealth.setDate(healthDate);
            newhealth.setTemp(healthTemp);
            newhealth.setHealthCdt(healthCdt);
            healthService.save(newhealth);
            healthValue=1;//上报成功
        }else{
            health.setTel(userTel);
            health.setDate(healthDate);
            health.setTemp(healthTemp);
            health.setHealthCdt(healthCdt);
            healthService.update(health);
            healthValue=2;//更新成功
        }

        reportresult.setStatusCode(healthValue);
        return reportresult;
    }

    @RequestMapping(value = "/query")
    public HealthInfoTool query(HttpServletRequest request){
        HealthInfoTool queryResult=new HealthInfoTool();
        Integer queryValue=0;
        String userTel =request.getParameter("tel");

        //获得日期
//        Date date = new Date();
//        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        String healthDate = format.format(date);

        ArrayList<Health> healths;
        healths=healthService.findByUserTel (userTel);
        ArrayList<HealthInfo> healthInfos=new ArrayList<>();

        if(healths.size()>0){
            for (Health eachhealth:healths) {
                HealthInfo healthInfo=new HealthInfo();
                String date=eachhealth.getDate();
                Float temp=eachhealth.getTemp();
                Integer cdt=eachhealth.getHealthCdt();
                healthInfo.setInfo(date,temp,cdt);
                healthInfos.add(healthInfo);
            }
            queryResult.setData(healthInfos);
            queryValue=1;

        }

        queryResult.setStatusCode(queryValue);
        return queryResult;
    }
}
