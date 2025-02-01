package com.dp.edu.repository;

import com.dp.edu.model.tables.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
    boolean existsByEmail(String email);
}