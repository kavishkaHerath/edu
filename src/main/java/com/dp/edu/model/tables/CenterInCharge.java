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

}
