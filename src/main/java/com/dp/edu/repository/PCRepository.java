package com.dp.edu.repository;

import com.dp.edu.model.tables.PC;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PCRepository extends JpaRepository<PC, String> {
}
