package com.dp.edu.model.request;

import com.dp.edu.model.tables.Center;
import lombok.Getter;
import lombok.Setter;


public class CenterInChargeDTO {
    private String centerInChargeCode;
    private String name;
    private String email;
    private String phoneNumber;
    private String address;
    private String centerCode;
    private String userCode;

    public CenterInChargeDTO() {
    }

    public CenterInChargeDTO(String centerInChargeCode, String name, String email, String phoneNumber, String address, String centerCode, String userCode) {
        this.centerInChargeCode = centerInChargeCode;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.centerCode = centerCode;
        this.userCode = userCode;
    }

    public String getCenterInChargeCode() {
        return centerInChargeCode;
    }

    public void setCenterInChargeCode(String centerInChargeCode) {
        this.centerInChargeCode = centerInChargeCode;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCenterCode() {
        return centerCode;
    }

    public void setCenterCode(String centerCode) {
        this.centerCode = centerCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
}
