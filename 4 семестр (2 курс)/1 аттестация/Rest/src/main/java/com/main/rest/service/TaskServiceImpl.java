package com.main.rest.service;

import com.main.rest.entity.Person;
import com.main.rest.entity.Task;
import com.main.rest.repository.PersonRepository;
import com.main.rest.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TaskServiceImpl implements TaskService {
    private static final AtomicInteger TASK_ID = new AtomicInteger();

    @Autowired
    TaskRepository Repo;

    @Override
    public Task create(Task task) {

        final int taskid = TASK_ID.incrementAndGet();
        task.setId((long) taskid);
        Repo.save(task);
        return task;
    }

    @Override
    public List<Task> readAll() {
        create(new Task());
        return new ArrayList<>(Repo.findAll());
    }

    @Override
    public Task read(int id) {
        return Repo.findById(id);
    }


    @Override
    public boolean update(Task task, int id) {
        Task buff = Repo.findById(id);
        if (buff == null){
            return false;
        }
        System.out.println("БОЛУЧИЛИ БУФЕР");
        System.out.println(buff);
        //Удаляем данные старые
        Repo.delete(buff);
        //Добавляем новые данные
        Repo.save(task);
        return true;
    }

    @Override
    public boolean delete(int id) {
        Task buff = Repo.findById(id);
        if (buff != null) {
            Repo.delete(buff);
            return true;
        }
        return false;
    }


}
