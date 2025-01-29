package com.dp.edu.repository;

import com.dp.edu.model.tables.CenterInCharge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CenterInChargeRepository extends JpaRepository<CenterInCharge, String> {
    boolean existsByEmail(String email);

    @Query("SELECT COUNT(c) FROM CenterInCharge c WHERE c.center.centerCode = ?1")
    int countByCenterCode(String centerCode);
}
