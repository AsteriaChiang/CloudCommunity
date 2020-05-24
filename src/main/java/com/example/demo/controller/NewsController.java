package com.example.demo.controller;

import com.example.demo.entity.News;
import com.example.demo.service.NewsService;
import com.example.demo.utils.HealthInfoTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@RestController
@RequestMapping(value="/news")
public class NewsController {
    @Autowired
    private NewsService newsService;
    private News news = new News();

    @RequestMapping(value = "/show")
    public ArrayList<News> show(HttpServletRequest request) {
        ArrayList<News> newsExits=newsService.findNews();
        ArrayList<News> newsList=new ArrayList<>();
        for (News news:newsExits) {
            News newsInfo=new News();
            newsInfo.setNewsId(news.getNewsId());
            newsInfo.setAuthorAvatar(news.getAuthorAvatar());
            newsInfo.setNewsTitle(news.getNewsTitle());
            newsInfo.setPostDate(news.getPostDate());
            newsList.add(newsInfo);
        }

        return newsList;
    }

    @RequestMapping(value = "/search")
    public News search(HttpServletRequest request) {
        Integer id=0;
        if(request.getParameter("id")!=null){
            id= Integer.parseInt(request.getParameter("id"));}

        news=newsService.findById(id);
        News searchNews=new News();
        searchNews.setNewsTitle(news.getNewsTitle());
        searchNews.setNewsContent(news.getNewsContent());

        return searchNews;
    }

}
