package com.dp.edu.model.tables;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TBL_CENTER_IN_CHARGE")
public class CenterInCharge {
    @Id
    @Column(name = "STR_CENTER_IN_CHARGE_CODE", nullable = false, length = 8)
    private String centerInChargeCode;
    @Column(name = "STR_NAME", nullable = false)
    private String name;
    @Column(name = "STR_EMAIL", nullable = false, unique = true, length = 250)
    private String email;
    @Column(name = "STR_PHONE", nullable = false, unique = true, length = 10)
    private String phoneNumber;
    @Column(name = "STR_ADDRESS", nullable = false)
    private String address;

    @ManyToOne
    @JoinColumn(name = "STR_CENTER_CODE", referencedColumnName = "STR_CENTER_CODE", nullable = false)
    private Center center;

    @Column(name = "STR_USER_CODE", nullable = false, length = 8)
    private String userCode;

    public CenterInCharge() {
    }

    public CenterInCharge(String centerInChargeCode, String name, String email, String phoneNumber, String address, Center center, String userCode) {
        this.centerInChargeCode = centerInChargeCode;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.center = center;
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

    public Center getCenter() {
        return center;
    }

    public void setCenter(Center center) {
        this.center = center;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
}
