package com.dp.edu.model.output;

import lombok.Data;

@Data
public class PCsDetails {
    private String pcsCode;
    private String registerDate;
    private String centerCode;

    public PCsDetails() {
    }

    public PCsDetails(String pcsCode, String registerDate, String centerCode) {
        this.pcsCode = pcsCode;
        this.registerDate = registerDate;
        this.centerCode = centerCode;
    }

    public String getPcsCode() {
        return pcsCode;
    }

    public void setPcsCode(String pcsCode) {
        this.pcsCode = pcsCode;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public String getCenterCode() {
        return centerCode;
    }

    public void setCenterCode(String centerCode) {
        this.centerCode = centerCode;
    }
}
