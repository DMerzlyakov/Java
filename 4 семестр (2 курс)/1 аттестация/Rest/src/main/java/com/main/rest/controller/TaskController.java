package com.main.rest.controller;

import com.main.rest.entity.Person;
import com.main.rest.entity.Task;
import com.main.rest.service.PersonService;
import com.main.rest.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }


    @PostMapping(value = "/task")
    public ResponseEntity<?> create(Task task) {
        Task newTask = taskService.create(new Task());
        System.out.println("Добавляю");
        return new ResponseEntity<>(newTask, HttpStatus.CREATED);
    }

    @GetMapping(value = "/tasks")
    public ResponseEntity<List<Task>> read() {

        final List<Task> tasks = taskService.readAll();
        return tasks != null && !tasks.isEmpty() ? new ResponseEntity<>(tasks, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/task/{id}")
    public ResponseEntity<Task> read(@PathVariable(name = "id") int id) {
        final Task task = taskService.read(id);
        return task != null ? new ResponseEntity<>(task, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/persons/{id}")
    public ResponseEntity<Task> put(@PathVariable(name = "id") int id, @RequestBody Task newTask) {

        //Если успешно обновлили данные
        if (taskService.update(newTask, id)) {
            //id персоны чтоб отдавался
            Task newTaskById = taskService.read(id);
            return new ResponseEntity<>(newTaskById, HttpStatus.OK);
        }
        //Если не получилось обновить данные
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/task/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id) {
        final Task task = taskService.read(id);
        if (task != null) {
            taskService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
