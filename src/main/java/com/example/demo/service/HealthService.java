package com.example.demo.service;


import com.example.demo.entity.Health;
import com.example.demo.respository.HealthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class HealthService {

    @Autowired
    private HealthRepository healthRepository;

    public Health findByUserTelAndDate(String tel, Date healthDate)
    {
        return healthRepository.findByUserTelAndDate (tel,healthDate);
    }

    public void save (Health health)
    {
        healthRepository.save (health);
    }
}
