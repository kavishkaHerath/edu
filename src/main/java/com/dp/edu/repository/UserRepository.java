package com.dp.edu.repository;

import com.dp.edu.model.tables.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, String> {
    boolean existsByEmail(String email);

    boolean existsByPasswordAndEmail(String password, String email);

  //  User findByEmail(String email);
}
