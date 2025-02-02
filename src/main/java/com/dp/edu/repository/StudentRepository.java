package com.dp.edu.repository;

import com.dp.edu.model.tables.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, String> {
    boolean existsByEmail(String email);

    Student findByEmail(String email);

    @Query("SELECT COUNT(s) FROM Student s WHERE s.center.centerCode = ?1")
    int countByCenterCode(String centerCode);
}