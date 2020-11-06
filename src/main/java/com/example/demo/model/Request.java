package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Table(name="\"request\"")
@Data
public class Request {
    @NonNull
    @Id
    @Column(name = "req_id")
    private String reqId;

    @Column(name = "req_date")
    private LocalTime reqDate;

    @Column(name = "req_deadline")
    private LocalTime reqDeadline;

    @Column(name = "req_amount")
    private int reqAmount;

    @Column(name = "req_reason")
    private String reqReason;

    @Column(name = "req_title")
    private String reqTitle;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public LocalTime getReqDate() {
        return reqDate;
    }

    public void setReqDate(LocalTime reqDate) {
        this.reqDate = reqDate;
    }

    public LocalTime getReqDeadline() {
        return reqDeadline;
    }

    public void setReqDeadline(LocalTime reqDeadline) {
        this.reqDeadline = reqDeadline;
    }

    public int getReqAmount() {
        return reqAmount;
    }

    public void setReqAmount(int reqAmount) {
        this.reqAmount = reqAmount;
    }

    public String getReqReason() {
        return reqReason;
    }

    public void setReqReason(String reqReason) {
        this.reqReason = reqReason;
    }

    public String getReqTitle() {
        return reqTitle;
    }

    public void setReqTitle(String reqTitle) {
        this.reqTitle = reqTitle;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}