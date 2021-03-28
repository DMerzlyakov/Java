package com.main.rest.repository;

import com.main.rest.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NewsRepository extends JpaRepository<News, Long> {
    List<News> findNewsByCategoryName(String name);
    News findById(long id);
}