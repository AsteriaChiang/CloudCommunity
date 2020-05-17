package com.example.demo.respository;

import com.example.demo.entity.Health;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;


public interface HealthRepository extends JpaRepository<Health,Long> {

    @Query("select s from Health s where s.userTel = ?1 and s.healthDate = ?2")
    Health findByUserTelAndDate (String userTel, Date healthDate);

}