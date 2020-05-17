package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value="/user")
public class UserController {
    @Autowired
    private UserService userService;
    private User user = new User();

    @RequestMapping(value = "/login")
    public Integer login(HttpServletRequest request){
        Integer loginValue=0;
        String tel = request.getParameter("tel");
        String password = request.getParameter("password");

        user = userService.findByUserTelAndPwd(tel, password);

        if(user!=null){
            loginValue=1;//登陆成功
        }
        return loginValue;
    }

    @RequestMapping(value = "/update")
    public Integer update(HttpServletRequest request) {
        Integer updateValue=0;

        String tel = request.getParameter("tel");
        String name = request.getParameter("name");
        Integer sex = Integer.valueOf(request.getParameter("sex"));
        String ic = request.getParameter("ic");

        user = userService.findByUserTel(tel);
        if(user!=null){

            user.setTel(tel);
            user.setName(name);
            user.setSex(sex);
            user.setIc(ic);
            userService.update(user);
            updateValue=1;
        }


        return updateValue;
    }
}
