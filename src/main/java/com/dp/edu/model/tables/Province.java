package com.dp.edu.model.tables;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TBL_PROVINCES")
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INT_PROVINCE_ID")
    private int provinceId;
    @Column(name = "STR_PROVINCE_NAME", unique = true, nullable = false)
    private String provinceName;
}
