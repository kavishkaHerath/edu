package com.dp.edu.model.tables;

import jakarta.persistence.*;

import javax.xml.crypto.Data;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "TBL_STUDENT_ATTENDANCES")
public class StudentAttendance {
    @Id
    @Column(name = "STR_ATTENDANCE_CODE", nullable = false, length = 20)
    private String attendanceCode;

    @ManyToOne
    @JoinColumn(name = "STR_STUDENT_CODE", referencedColumnName = "STR_STUDENT_CODE", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name="STR_PC_CODE", referencedColumnName = "STR_PC_CODE", nullable = false)
    private PC pc;

    @ManyToOne
    @JoinColumn(name = "STR_CENTER_CODE", referencedColumnName = "STR_CENTER_CODE", nullable = false)
    private Center center;

    @Column(name = "STR_LOGING_TIME", nullable = false)
    private LocalTime loginTime;

    @Column(name = "STR_LOGOUT_TIME")
    private LocalTime logoutTime;

    @Column(name = "DATE_ATTENDANCE_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date attedanceDate;

    @Column(name = "INT_DURATION")
    private int duration;

    public StudentAttendance() {
    }

    public StudentAttendance(String attendanceCode, Student student, PC pc, Center center, LocalTime loginTime, LocalTime logoutTime, Date attedanceDate, int duration) {
        this.attendanceCode = attendanceCode;
        this.student = student;
        this.pc = pc;
        this.center = center;
        this.loginTime = loginTime;
        this.logoutTime = logoutTime;
        this.attedanceDate = attedanceDate;
        this.duration = duration;
    }

    public String getAttendanceCode() {
        return attendanceCode;
    }

    public void setAttendanceCode(String attendanceCode) {
        this.attendanceCode = attendanceCode;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public PC getPc() {
        return pc;
    }

    public void setPc(PC pc) {
        this.pc = pc;
    }

    public Center getCenter() {
        return center;
    }

    public void setCenter(Center center) {
        this.center = center;
    }

    public LocalTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalTime loginTime) {
        this.loginTime = loginTime;
    }

    public LocalTime getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(LocalTime logoutTime) {
        this.logoutTime = logoutTime;
    }

    public Date getAttedanceDate() {
        return attedanceDate;
    }

    public void setAttedanceDate(Date attedanceDate) {
        this.attedanceDate = attedanceDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
