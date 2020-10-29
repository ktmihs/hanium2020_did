package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Table(name="\"request\"")
@Data
public class request {
    @NonNull
    @Id
    @Column(name="req_id")
    private String req_id;
    @Id
    @Column(name="req_date")
    private LocalTime req_date;
    @Id
    @Column(name="req_deadline")
    private LocalTime req_deadline;
    @Id
    @Column(name="req_amount")
    private int req_amount;
    @Id
    @Column(name="req_reason")
    private String req_reason;
    @Id
    @Column(name="req_title")
    private String req_title;
    @Id
    @Column(name="user_id")
    private String user_id;

    public String getReq_id() {
        return req_id;
    }

    public void setReq_id(String req_id) {
        this.req_id = req_id;
    }

    public LocalTime getReq_date() {
        return req_date;
    }

    public void setReq_date(LocalTime req_date) {
        this.req_date = req_date;
    }

    public LocalTime getReq_deadline() {
        return req_deadline;
    }

    public void setReq_deadline(LocalTime req_deadline) {
        this.req_deadline = req_deadline;
    }

    public int getReq_amount() {
        return req_amount;
    }

    public void setReq_amount(int req_amount) {
        this.req_amount = req_amount;
    }

    public String getReq_reason() {
        return req_reason;
    }

    public void setReq_reason(String req_reason) {
        this.req_reason = req_reason;
    }

    public String getReq_title() {
        return req_title;
    }

    public void setReq_title(String req_title) {
        this.req_title = req_title;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
