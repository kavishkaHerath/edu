package com.dp.edu.model.request;

import lombok.Data;

@Data
public class CenterRequestDTO {
    private String centerCode;
    private String centerName;
    private Integer provinceId;
    private Integer districtId;
    private String address;
    private int pcCount;
}
