package com.example.demo.controller;

import com.example.demo.entity.Health;
import com.example.demo.entity.User;
import com.example.demo.service.HealthService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping(value="/health")
public class HealthController {

    @Autowired
    private UserService userService;
    @Autowired
    private HealthService healthService;
    private Health health = new Health();
    private User user=new User();

    @RequestMapping(value = "/save")
    public Integer update(HttpServletRequest request) throws ParseException {
        Integer updateValue=0;

        String userTel = request.getParameter("tel");
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        Float healthTemp = Float.parseFloat(request.getParameter("temp"));


        user = userService.findByUserTel(userTel);
        if(user!=null){
            health.setTel(userTel);
            health.setDate(date);
            health.setTemp(healthTemp);
            healthService.save(health);
            updateValue=1;
        }


        return updateValue;
    }
}
