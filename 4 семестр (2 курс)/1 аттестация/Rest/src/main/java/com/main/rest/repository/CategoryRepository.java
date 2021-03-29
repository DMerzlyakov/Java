package com.main.rest.repository;

import com.main.rest.entity.Category;
import com.main.rest.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findById(long id);
}