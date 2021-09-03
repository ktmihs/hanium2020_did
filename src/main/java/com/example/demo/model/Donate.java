package com.example.demo.model;
import javax.persistence.Column;

import lombok.*;
<<<<<<< HEAD
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
=======
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
>>>>>>> 79a0b908c4b665403b5fe0fc69cd1c64075e2f16
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Table(name="\"donate\"")
@Data
<<<<<<< HEAD
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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @CreationTimestamp
=======
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

>>>>>>> 79a0b908c4b665403b5fe0fc69cd1c64075e2f16
    @Column (name = "donate_date")
    private LocalDateTime donateDate;

    @Column(name = "donate_amount")
    private int donateAmount;

<<<<<<< HEAD
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

=======
    @Column(name = "donate_cancel")
    private LocalDateTime donateCancel;

    public DonateId getDonateId() {
        return donateId;
    }

    public void setDonateId(DonateId donateId) {
        this.donateId = donateId;
    }

>>>>>>> 79a0b908c4b665403b5fe0fc69cd1c64075e2f16
    public LocalDateTime getDonateDate() {
        return donateDate;
    }

    public void setDonateDate(LocalDateTime donateDate) {
        this.donateDate = donateDate;
    }

    public int getDonateAmount() {
        return donateAmount;
    }

    public void setDonateAmount(int donateAmount) {
        this.donateAmount = donateAmount;
    }

<<<<<<< HEAD
=======
    public LocalDateTime getDonateCancel() {
        return donateCancel;
    }

    public void setDonateCancel(LocalDateTime donateCancel) {
        this.donateCancel = donateCancel;
    }
>>>>>>> 79a0b908c4b665403b5fe0fc69cd1c64075e2f16
}