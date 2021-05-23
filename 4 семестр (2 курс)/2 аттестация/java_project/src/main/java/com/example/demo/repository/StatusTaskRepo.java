package com.example.demo.repository;

import com.example.demo.models.StatusTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusTaskRepo extends JpaRepository<StatusTask, Long> {
}
