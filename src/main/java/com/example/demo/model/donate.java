package com.example.demo.model;
import javax.persistence.Column;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Table(name="\"donate\"")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Donate {

    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "donate_id")
    private Integer donateId;

    @OneToOne
    @JoinColumn(name = "req_id")
    private Request request;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column (name = "donate_date")
    private LocalTime donateDate;

    @Column(name = "donate_amount")
    private int donateAmount;

    public Integer getDonateId() {
        return donateId;
    }

    public void setDonateId(Integer donateId) {
        this.donateId = donateId;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalTime getDonateDate() {
        return donateDate;
    }

    public void setDonateDate(LocalTime donateDate) {
        this.donateDate = donateDate;
    }

    public int getDonateAmount() {
        return donateAmount;
    }

    public void setDonateAmount(int donateAmount) {
        this.donateAmount = donateAmount;
    }

}