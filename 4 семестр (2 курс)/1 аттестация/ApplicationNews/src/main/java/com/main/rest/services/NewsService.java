package com.main.rest.services;

import com.main.rest.entity.News;
import com.main.rest.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public void create(News news) {
        newsRepository.save(news);
    }

    public List<News> findAll() {
        return newsRepository.findAll();
    }

    public Optional<News> findById(Long id) {return newsRepository.findById(id);
    }

    public void deleteById(Long id){
        newsRepository.deleteById(id);
    }

}
