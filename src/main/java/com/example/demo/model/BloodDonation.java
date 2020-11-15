package com.example.demo.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Table(name="\"blood_donation\"")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BloodDonation {

    @NonNull
    @Id
    @Column(name = "bd_id")
    private String bdId;

    @JoinColumn(name = "bdi_id")
    @ManyToOne
    private BloodInstitution bloodInstitution;

    @Column(name = "bd_type")
    private String bdType;

    @Column(name = "bd_amount")
    private int bdAmount;

    @CreationTimestamp
    @Column(name = "bd_date")
    private LocalDateTime bdDate;

    @Column(name = "bd_check")
    private byte bdCheck;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

    public String getBdId() {
        return bdId;
    }

    public void setBdId(String bdId) {
        this.bdId = bdId;
    }

    public BloodInstitution getBloodInstitution() {
        return bloodInstitution;
    }

    public void setBloodInstitution(BloodInstitution bloodInstitution) {
        this.bloodInstitution = bloodInstitution;
    }

    public String getBdType() {
        return bdType;
    }

    public void setBdType(String bdType) {
        this.bdType = bdType;
    }

    public int getBdAmount() {
        return bdAmount;
    }

    public void setBdAmount(int bdAmount) {
        this.bdAmount = bdAmount;
    }

    public LocalDateTime getBdDate() {
        return bdDate;
    }

    public void setBdDate(LocalDateTime bdDate) {
        this.bdDate = bdDate;
    }

    public byte getBdCheck() {
        return bdCheck;
    }

    public void setBdCheck(byte bdCheck) {
        this.bdCheck = bdCheck;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    //    public String getUser_id() {
//        return user_id;
//    }
//
//    public void setUser_id(String user_id) {
//        this.user_id = user_id;
//    }
}
