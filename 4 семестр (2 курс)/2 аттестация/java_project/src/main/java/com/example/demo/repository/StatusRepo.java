package com.example.demo.repository;

import com.example.demo.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepo extends JpaRepository<Status, Long> {

    Status findStatusByRowId(Long id);
}
