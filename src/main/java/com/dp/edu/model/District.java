package com.dp.edu.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "TBL_DISTRICTS")
@Data
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INT_DISTRICT_ID")
    private Integer districtId;

    @Column(name = "STR_DISTRICT_NAME", unique = true, nullable = false)
    private String districtName;

    @ManyToOne
    @JoinColumn(name = "INT_PROVINCE_ID", referencedColumnName = "INT_PROVINCE_ID", nullable = false)
    private Province province;
}
