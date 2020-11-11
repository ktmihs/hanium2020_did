package com.example.demo.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Table(name="\"request\"")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request {
    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "req_id")
    private Integer reqId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @CreationTimestamp
    @Column(name = "req_date")
    private LocalDate reqDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "req_deadline")
    private LocalDate reqDeadline;

    @Column(name = "req_amount")
    private int reqAmount;

    @Column(name = "req_reason")
    private String reqReason;

    @Column(name = "req_title")
    private String reqTitle;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    
    @Builder
    public Request(Integer reqId, LocalDate reqDeadline, int reqAmount, String reqTitle, String reqReason){
        this.reqId=reqId;
        this.reqDeadline=reqDeadline;
        this.reqAmount=reqAmount;
        this.reqTitle=reqTitle;
        this.reqReason=reqReason;
    }
    public Integer getReqId() {
        return reqId;
    }

    public void setReqId(Integer reqId) {
        this.reqId = reqId;
    }

    public LocalDate getReqDate() {
        return reqDate;
    }

    public void setReqDate(LocalDate reqDate) {
        this.reqDate = reqDate;
    }

    public LocalDate getReqDeadline() {
        return reqDeadline;
    }

    public void setReqDeadline(LocalDate reqDeadline) {
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