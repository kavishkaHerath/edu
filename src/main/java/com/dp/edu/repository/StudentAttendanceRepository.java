package com.dp.edu.repository;

import com.dp.edu.model.tables.StudentAttendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentAttendanceRepository extends JpaRepository<StudentAttendance, String> {
}
