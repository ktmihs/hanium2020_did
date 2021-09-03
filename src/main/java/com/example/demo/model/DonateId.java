package com.example.demo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;

@Data
@Embeddable
//@Table(name="\"donate\"")
@NoArgsConstructor

public class DonateId implements Serializable {
    @Column(name = "req_id")
    private String reqId;

    @Column(name = "user_id")
    private String userId;
}
