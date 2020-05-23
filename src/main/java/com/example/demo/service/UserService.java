package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByUserTelAndPwd(String tel, String pwd)
    {
        return userRepository.findByUserTelAndPwd (tel, pwd);
    }

    public User findByUserTel(String tel)
    {
        return userRepository.findByUserTel (tel);
    }

    public void update (User user)
    {
        userRepository.save (user);
    }

    public void save (User user)
    {
        userRepository.save (user);
    }
}
