package com.example.demo.model;

<<<<<<< HEAD
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
=======
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
>>>>>>> 79a0b908c4b665403b5fe0fc69cd1c64075e2f16

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.*;
<<<<<<< HEAD
import java.io.Serializable;
import java.time.LocalDate;
=======
>>>>>>> 79a0b908c4b665403b5fe0fc69cd1c64075e2f16
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Table(name="\"request\"")
@Data
<<<<<<< HEAD
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
=======
public class Request {
    @NonNull
    @Id
    @Column(name = "req_id")
    private String reqId;

    @Column(name = "req_date")
    private LocalTime reqDate;

    @Column(name = "req_deadline")
    private LocalTime reqDeadline;
>>>>>>> 79a0b908c4b665403b5fe0fc69cd1c64075e2f16

    @Column(name = "req_amount")
    private int reqAmount;

<<<<<<< HEAD
    @Column(name = "req_total")
    private int reqTotal;

=======
>>>>>>> 79a0b908c4b665403b5fe0fc69cd1c64075e2f16
    @Column(name = "req_reason")
    private String reqReason;

    @Column(name = "req_title")
    private String reqTitle;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

<<<<<<< HEAD
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
=======
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
>>>>>>> 79a0b908c4b665403b5fe0fc69cd1c64075e2f16
        this.reqDeadline = reqDeadline;
    }

    public int getReqAmount() {
        return reqAmount;
    }

    public void setReqAmount(int reqAmount) {
        this.reqAmount = reqAmount;
    }

<<<<<<< HEAD
    public int getReqTotal() {
        return reqTotal;
    }

    public void setReqTotal(int reqTotal) {
        this.reqTotal = reqTotal;
    }

=======
>>>>>>> 79a0b908c4b665403b5fe0fc69cd1c64075e2f16
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