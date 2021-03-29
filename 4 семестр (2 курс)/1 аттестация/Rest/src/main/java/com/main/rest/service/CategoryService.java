package com.main.rest.service;

import com.main.rest.entity.Category;
import com.main.rest.entity.Person;

import java.util.List;

public interface CategoryService {
    Category create(Category category);

    List<Category> readAll();

    Category read(int id);

    boolean update(Category category, int id);

    boolean delete(int id);
}
