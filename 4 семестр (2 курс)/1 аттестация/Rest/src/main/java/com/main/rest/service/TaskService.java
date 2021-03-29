package com.main.rest.service;

import com.main.rest.entity.Person;
import com.main.rest.entity.Task;

import java.util.List;

public interface TaskService {
    Task create(Task task);

    List<Task> readAll();

    Task read(int id);

    boolean update(Task task, int id);

    boolean delete(int id);
}
