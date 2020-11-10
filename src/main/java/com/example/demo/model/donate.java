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
    @EmbeddedId
    private DonateId donateId;
//    @Id
//    @OneToOne
//    @JoinColumn(name = "request_id")
//    private Request request;
//
//    @Id
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

    @Column (name = "donate_date")
    private LocalTime donateDate;

    @Column(name = "donate_amount")
    private int donateAmount;

    @Column(name = "donate_cancel")
    private LocalTime donateCancel;

    public DonateId getDonateId() {
        return donateId;
    }

    public void setDonateId(DonateId donateId) {
        this.donateId = donateId;
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

    public LocalTime getDonateCancel() {
        return donateCancel;
    }

    public void setDonateCancel(LocalTime donateCancel) {
        this.donateCancel = donateCancel;
    }
}