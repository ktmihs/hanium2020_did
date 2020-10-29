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
@Table(name="\"donate\"")
@Data
public class donate {
    @NonNull
    @Id
    @Column(name="req_id")
    private String req_id;
    @NonNull
    @Id
    @Column(name="user_id")
    private String user_id;
    @Id
    @Column(name="donate_date")
    private LocalTime donate_date;
    @Id
    @Column(name="donate_amount")
    private int donate_amount;
    @Id
    @Column(name="donate_cancel")
    private LocalTime donate_cancel;

    public String getReq_id() {
        return req_id;
    }

    public void setReq_id(String req_id) {
        this.req_id = req_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public LocalTime getDonate_date() {
        return donate_date;
    }

    public void setDonate_date(LocalTime donate_date) {
        this.donate_date = donate_date;
    }

    public int getDonate_amount() {
        return donate_amount;
    }

    public void setDonate_amount(int donate_amount) {
        this.donate_amount = donate_amount;
    }

    public LocalTime getDonate_cancel() {
        return donate_cancel;
    }

    public void setDonate_cancel(LocalTime donate_cancel) {
        this.donate_cancel = donate_cancel;
    }
}
