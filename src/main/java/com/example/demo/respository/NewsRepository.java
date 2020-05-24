package com.example.demo.respository;

import com.example.demo.entity.Health;
import com.example.demo.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface NewsRepository extends JpaRepository<News,Long> {

    @Query("select s from News s")
    ArrayList<News> findNews ();

    @Query("select s from News s where s.newsId = ?1")
    News findById (Integer newsId);

}