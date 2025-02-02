package com.dp.edu.model.tables;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "TBL_STUDENTS")
public class Student {
    @Id
    @Column(name = "STR_STUDENT_CODE", nullable = false, length = 12)
    private String studentCode;
    @Column(name = "STR_STUDENT_NAME", nullable = false)
    private String name;
    @Column(name = "STR_EMAIL", nullable = false, unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "STR_CENTER_CODE", referencedColumnName = "STR_CENTER_CODE", nullable = false)
    private Center center;

    @Column(name = "STR_PHONE_NUMBER", length = 10)
    private String phoneNumber;
    @Column(name = "STR_PARENT_PHONE_NUMBER", length = 10)
    private String parentPhoneNumber;
    @Column(name = "STR_ADDRESS")
    private String address;
    @Column(name = "DATE_ADD_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date addDate;

    public Student() {
    }

    public Student(String studentCode, String name, String email, Center center, String phoneNumber, String parentPhoneNumber, String address, Date addDate) {
        this.studentCode = studentCode;
        this.name = name;
        this.email = email;
        this.center = center;
        this.phoneNumber = phoneNumber;
        this.parentPhoneNumber = parentPhoneNumber;
        this.address = address;
        this.addDate = addDate;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Center getCenter() {
        return center;
    }

    public void setCenter(Center center) {
        this.center = center;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getParentPhoneNumber() {
        return parentPhoneNumber;
    }

    public void setParentPhoneNumber(String parentPhoneNumber) {
        this.parentPhoneNumber = parentPhoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }
}
