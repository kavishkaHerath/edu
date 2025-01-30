package com.dp.edu.repository;

import com.dp.edu.model.tables.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
