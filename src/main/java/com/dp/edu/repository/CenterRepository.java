package com.dp.edu.repository;

import com.dp.edu.model.tables.Center;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CenterRepository extends JpaRepository<Center, String> {
    boolean existsByCenterName(String centerName);
}
