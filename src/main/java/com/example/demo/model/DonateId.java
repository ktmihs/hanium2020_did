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
    private int reqId;

    @Column(name = "user_id")
    private LocalTime userId;
}
