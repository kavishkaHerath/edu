package com.dp.edu.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "TBL_PCS")
public class PC {
    @Id
    @Column(name = "STR_PC_CODE", nullable = false, length = 50)
    private String pcCode;

    @ManyToOne
    @JoinColumn(name = "STR_CENTER_CODE", referencedColumnName = "STR_CENTER_CODE", nullable = false)
    private Center center;

    @Column(name = "STR_STATUS", nullable = false)
    private boolean status;

    @Column(name = "DATE_REGISTRATION_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date registrationDate;

}
