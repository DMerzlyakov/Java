package com.main.rest.repository;

import com.main.rest.entity.Person;
import com.main.rest.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByName(String name);
    Task findById(long id);
}