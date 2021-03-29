package com.main.rest.controller;

import com.main.rest.entity.Category;
import com.main.rest.entity.Task;
import com.main.rest.service.CategoryService;
import com.main.rest.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    private final CategoryService catService;

    @Autowired
    public CategoryController(CategoryService catService) {
        this.catService = catService;
    }

    @GetMapping(value = "/Category/{id}")
    public ResponseEntity<Task> read(@PathVariable(name = "id") int id) {
        final Category cat = catService.read(id);
        return cat != null ? new ResponseEntity(cat, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/categories")
    public ResponseEntity<List<Category>> read() {

        final List<Category> cat = catService.readAll();
        return cat != null && !cat.isEmpty() ? new ResponseEntity<>(cat, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
