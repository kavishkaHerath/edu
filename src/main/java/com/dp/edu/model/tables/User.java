package com.dp.edu.model.tables;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TBL_USERS")
public class User {
    @Id
    @Column(name = "STR_USER_CODE", nullable = false, length = 8)
    private String userCode;
    @Column(name = "STR_USER_NAME", nullable = false, length = 100)
    private String username;
    @Column(name = "STR_USER_TYPE", nullable = false, length = 3)
    private String userType;
    @Column(name = "STR_PASSWORD", nullable = false, length = 30)
    private String password;
    @Column(name = "STR_EMAIL", nullable = false, unique = true)
    private String email;

    public User() {
    }

    public User(String userCode, String username, String userType, String password, String email) {
        this.userCode = userCode;
        this.username = username;
        this.userType = userType;
        this.password = password;
        this.email = email;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
