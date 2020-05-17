package com.example.demo.respository;


import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Long>  {

    @Query("select s from User s where s.tel = ?1 and s.password = ?2")
    User findByUserTelAndPwd (String userTel, String userPwd);

    @Query("select s from User s where s.tel = ?1")
    User findByUserTel (String userTel);
}