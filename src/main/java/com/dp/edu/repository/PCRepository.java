package com.dp.edu.repository;

import com.dp.edu.model.output.PCsDetails;
import com.dp.edu.model.tables.Center;
import com.dp.edu.model.tables.PC;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PCRepository extends JpaRepository<PC, String> {
    List<PC> findByCenter(Center center);
}
