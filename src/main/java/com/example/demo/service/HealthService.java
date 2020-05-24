package com.example.demo.service;


import com.example.demo.entity.Health;
import com.example.demo.respository.HealthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class HealthService {

    @Autowired
    private HealthRepository healthRepository;

    public Health findByUserTelAndDate(String tel, String healthDate)
    {
        return healthRepository.findByUserTelAndDate (tel,healthDate);
    }

    public ArrayList<Health> findByUserTel(String tel)
    {
        return healthRepository.findByUserTel (tel);
    }

    public void save (Health health)
    {
        healthRepository.save (health);
    }
    public void update (Health health)
    {
        healthRepository.save (health);
    }

}
