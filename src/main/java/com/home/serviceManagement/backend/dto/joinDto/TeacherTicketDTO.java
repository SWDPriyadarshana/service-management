package com.home.serviceManagement.backend.dto.joinDto;

import com.home.serviceManagement.backend.dto.TeacherDTO;
import com.home.serviceManagement.backend.dto.TicketDTO;
import com.home.serviceManagement.backend.entity.Teacher;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TeacherTicketDTO implements Serializable {

    private String teacherId;
    private String teacherName;
    private String teacherAddress;
    private String ticketId;
    private Date date;
    private String apparatusId;
    private String status;
    private Date issduingdate;
    private Date returningDate;
    private BigDecimal fine;
    private int qty;


    public TeacherTicketDTO() {
    }

    public TeacherTicketDTO(String teacherId, String teacherName, String teacherAddress, String ticketId, Date date, String apparatusId, String status, Date issduingdate, Date returningDate, BigDecimal fine, int qty) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.teacherAddress = teacherAddress;
        this.ticketId = ticketId;
        this.date = date;
        this.apparatusId = apparatusId;
        this.status = status;
        this.issduingdate = issduingdate;
        this.returningDate = returningDate;
        this.fine = fine;
        this.qty = qty;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherAddress() {
        return teacherAddress;
    }

    public void setTeacherAddress(String teacherAddress) {
        this.teacherAddress = teacherAddress;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getApparatusId() {
        return apparatusId;
    }

    public void setApparatusId(String apparatusId) {
        this.apparatusId = apparatusId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getIssduingdate() {
        return issduingdate;
    }

    public void setIssduingdate(Date issduingdate) {
        this.issduingdate = issduingdate;
    }

    public Date getReturningDate() {
        return returningDate;
    }

    public void setReturningDate(Date returningDate) {
        this.returningDate = returningDate;
    }

    public BigDecimal getFine() {
        return fine;
    }

    public void setFine(BigDecimal fine) {
        this.fine = fine;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "TeacherTicketDTO{" +
                "teacherId='" + teacherId + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", teacherAddress='" + teacherAddress + '\'' +
                ", ticketId='" + ticketId + '\'' +
                ", date=" + date +
                ", apparatusId='" + apparatusId + '\'' +
                ", status='" + status + '\'' +
                ", issduingdate=" + issduingdate +
                ", returningDate=" + returningDate +
                ", fine=" + fine +
                ", qty=" + qty +
                '}';
    }
}
