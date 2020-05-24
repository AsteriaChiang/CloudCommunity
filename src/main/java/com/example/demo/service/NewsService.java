package com.example.demo.service;

import com.example.demo.entity.News;
import com.example.demo.respository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public ArrayList<News> findNews()
    {
        return newsRepository.findNews ();
    }

    public News findById(Integer newsId)
    {
        return newsRepository.findById (newsId);
    }
}
