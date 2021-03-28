package com.main.rest.contollers;

import com.main.rest.entity.News;
import com.main.rest.repository.NewsRepository;
import com.main.rest.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class NewsController {
    private final NewsService newsService;

    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }


    @PostMapping("/news")
    public ResponseEntity<?> create(@RequestBody News news) {
        newsService.create(news);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/news")
    public ResponseEntity<List<News>> findAll() {
        final List<News> newsList = newsService.findAll();

        return newsList != null && !newsList.isEmpty()
                ? new ResponseEntity<>(newsList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/news/{id}")
    public ResponseEntity<Optional<News>> findById(@PathVariable(name = "id") Long id) {
        final Optional<News> news= newsService.findById(id);

        return news != null
                ? new ResponseEntity<>(news, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
