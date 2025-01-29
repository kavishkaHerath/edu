package com.dp.edu.response;

import lombok.Data;

@Data
public class ResponseMessage {
    private String o_sqlcode;
    private String o_sql_msg;
    private String retunValue;

    public ResponseMessage() {
    }

    public ResponseMessage(String o_sqlcode, String o_sql_msg, String retunValue) {
        this.o_sqlcode = o_sqlcode;
        this.o_sql_msg = o_sql_msg;
        this.retunValue = retunValue;
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

    public String getRetunValue() {
        return retunValue;
    }

    public void setRetunValue(String retunValue) {
        this.retunValue = retunValue;
    }
}
