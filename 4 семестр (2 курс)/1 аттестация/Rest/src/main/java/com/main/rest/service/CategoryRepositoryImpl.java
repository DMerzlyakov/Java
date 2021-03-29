package com.main.rest.service;

import com.main.rest.entity.Category;
import com.main.rest.entity.Task;
import com.main.rest.repository.CategoryRepository;
import com.main.rest.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class CategoryRepositoryImpl implements CategoryService {

    private static final AtomicInteger CATEGORY_ID = new AtomicInteger();

    @Autowired
    CategoryRepository Repo;

    @Override
    public Category create(Category category) {
        final int catId = CATEGORY_ID.incrementAndGet();
        category.setId((long) catId);
        Repo.save(category);
        return category;
    }

    @Override
    public List<Category> readAll() {
        create(new Category());
        return new ArrayList<>(Repo.findAll());
    }

    @Override
    public Category read(int id) {
        return Repo.findById(id);
    }

    @Override
    public boolean update(Category category, int id) {
        Category buff = Repo.findById(id);
        if (buff == null){
            return false;
        }
        System.out.println("БОЛУЧИЛИ БУФЕР");
        System.out.println(buff);
        //Удаляем данные старые
        Repo.delete(buff);
        //Добавляем новые данные
        Repo.save(category);
        return true;
    }

    @Override
    public boolean delete(int id) {
        Category buff = Repo.findById(id);
        if (buff != null) {
            Repo.delete(buff);
            return true;
        }
        return false;
    }
}
