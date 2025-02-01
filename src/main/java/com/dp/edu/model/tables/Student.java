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





}
