package com.dp.edu.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "TBL_CENTERS")
public class Center {
    @Id
    @Column(name = "STR_CENTER_CODE", nullable = false, length = 50)
    private String centerCode;
    @Column(name = "STR_CENTER_NAME", unique = true, nullable = false, length = 100)
    private String centerName;

    @ManyToOne
    @JoinColumn(name = "INT_PROVINCE_ID", referencedColumnName = "INT_PROVINCE_ID", nullable = false)
    private Province province; // Many-to-One relationship with Province

    @ManyToOne
    @JoinColumn(name = "INT_DISTRICT_ID", referencedColumnName = "INT_DISTRICT_ID", nullable = false)
    private District district; // Many-to-One relationship with District


    @Column(name = "STR_ADDRESS", nullable = false, length = 255)
    private String address;


    @Column(name = "STR_USER_CODE", nullable = false, length = 6)
    private String userCode;

    @Column(name = "DATE_CENTER_ADD_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date centerAddDate;
}
