package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;

@Data
@Embeddable
//@Table(name="\"donate\"")


public class DonateId implements Serializable {
    @Column(name = "req_id")
    private String reqId;

    @Column(name = "user_id")
    private String userId;

    public String getReqId() {
        return reqId;
    }

    public void setReqId(String reqId) {
        this.reqId = reqId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
