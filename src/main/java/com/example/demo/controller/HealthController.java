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
        Integer updateValue=0;

        String userTel =request.getParameter("tel");
//        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
//        Date date = new Date(System.currentTimeMillis());
        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String healthDate = format.format(date);

        Float healthTemp=(float)0.0;
        if(request.getParameter("temp")!=null){
            healthTemp= Float.parseFloat(request.getParameter("temp"));}
        String healthCdt=request.getParameter("cdt");

        user = userService.findByUserTel(userTel);
        if(user!=null){
            health.setTel(userTel);
            health.setDate(healthDate);
            health.setTemp(healthTemp);
            health.setCdt(healthCdt);
            healthService.save(health);
            updateValue=1;
        }


        return updateValue;
    }

    @RequestMapping(value = "/query")
    public List<String> query(HttpServletRequest request){
        List<String> healthList=new ArrayList<>();
        String userTel =request.getParameter("tel");

        Date date = new Date();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String healthDate = format.format(date);
        health=healthService.findByUserTelAndDate(userTel,healthDate);
        user=userService.findByUserTel(userTel);

        if(health!=null){
            healthList.add(user.getName());
            healthList.add(user.getIc());
            healthList.add(health.getTemp().toString());
            healthList.add(health.getCdt());
            System.out.println(healthList);
        }
        else {
            healthList.add(null);
        }

        return healthList;
    }
}
