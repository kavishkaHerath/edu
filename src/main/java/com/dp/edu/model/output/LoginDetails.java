package com.dp.edu.model.output;

public class LoginDetails {
    private String userCode;
    private String userName;
    private String userType;
    private String centerCode;
    private String attendanceCode;
    private String o_sqlcode;
    private String o_sql_msg;

    public LoginDetails() {
    }

    public LoginDetails(String userCode, String userName, String userType, String centerCode, String attendanceCode,
                        String o_sqlcode, String o_sql_msg) {
        this.userCode = userCode;
        this.userName = userName;
        this.userType = userType;
        this.centerCode = centerCode;
        this.attendanceCode = attendanceCode;
        this.o_sqlcode = o_sqlcode;
        this.o_sql_msg = o_sql_msg;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getCenterCode() {
        return centerCode;
    }

    public void setCenterCode(String centerCode) {
        this.centerCode = centerCode;
    }

    public String getAttendanceCode() {
        return attendanceCode;
    }

    public void setAttendanceCode(String attendanceCode) {
        this.attendanceCode = attendanceCode;
    }

    public String getO_sqlcode() {
        return o_sqlcode;
    }

    public void setO_sqlcode(String o_sqlcode) {
        this.o_sqlcode = o_sqlcode;
    }

    public String getO_sql_msg() {
        return o_sql_msg;
    }

    public void setO_sql_msg(String o_sql_msg) {
        this.o_sql_msg = o_sql_msg;
    }
}
