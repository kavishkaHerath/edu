package com.dp.edu.model.request;

import lombok.Data;

@Data
public class StudentDTO {
    private String studentCode;
    private String studentName;
    private String email;
    private String centerCode;
    private String phoneNumber;
    private String parentPhoneNumber;
    private String address;
    private String pcCode;
    private String attendanceCode;

    public StudentDTO() {
    }

    public StudentDTO(String studentCode, String studentName, String email, String centerCode, String phoneNumber, String parentPhoneNumber, String address) {
        this.studentCode = studentCode;
        this.studentName = studentName;
        this.email = email;
        this.centerCode = centerCode;
        this.phoneNumber = phoneNumber;
        this.parentPhoneNumber = parentPhoneNumber;
        this.address = address;
    }

    public StudentDTO(String pcCode, String attendanceCode) {
        this.pcCode = pcCode;
        this.attendanceCode = attendanceCode;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCenterCode() {
        return centerCode;
    }

    public void setCenterCode(String centerCode) {
        this.centerCode = centerCode;
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

    public String getPcCode() {
        return pcCode;
    }

    public void setPcCode(String pcCode) {
        this.pcCode = pcCode;
    }

    public String getAttendanceCode() {
        return attendanceCode;
    }

    public void setAttendanceCode(String attendanceCode) {
        this.attendanceCode = attendanceCode;
    }
}
