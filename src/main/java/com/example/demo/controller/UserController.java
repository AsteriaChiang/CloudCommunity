package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.UserInfoTool;
import com.example.demo.utils.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
    public UserInfoTool login(HttpServletRequest request){
        UserInfoTool loginResult=new UserInfoTool();
        UserInfo loginUser=new UserInfo();
        Integer loginValue=0;
        String tel = request.getParameter("tel");
        String password = request.getParameter("password");

        user = userService.findByUserTelAndPwd(tel, password);//判断用户是否存在
        if(user!=null){
            String name=user.getName();
            String ic=user.getIc();
            Integer sex=user.getSex();
            loginUser.setInfo(tel,name,ic,sex);
            loginResult.setData(loginUser);
            loginValue=1;//登陆成功
        }

        loginResult.setStatusCode(loginValue);
        return loginResult;
    }

    @RequestMapping(value = "/register")
    public UserInfoTool register(HttpServletRequest request) {
        Integer registerValue = 0;
        UserInfoTool registerResult=new UserInfoTool();

        String tel = request.getParameter("tel");
        String name = request.getParameter("name");
        Integer sex = Integer.valueOf(request.getParameter("sex"));
        String ic = request.getParameter("ic");
        String password = request.getParameter("password");

        user = userService.findByUserTel(tel);
        if (user == null) {
            User newuser = new User();
            newuser.setTel(tel);
            newuser.setName(name);
            newuser.setSex(sex);
            newuser.setIc(ic);
            newuser.setPassword(password);
            userService.save(newuser);
            registerValue = 1;
        }

        registerResult.setStatusCode(registerValue);
        return registerResult;
    }

    @RequestMapping(value = "/update")
    public UserInfoTool update(HttpServletRequest request) {
        Integer updateValue=0;
        UserInfoTool updateResult=new UserInfoTool();

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

        updateResult.setStatusCode(updateValue);
        return updateResult;
    }
}
