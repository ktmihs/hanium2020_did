<<<<<<< HEAD
package com.example.demo.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
=======


        package com.example.demo.model;

        import lombok.Data;
        import lombok.Getter;
        import lombok.NonNull;
        import lombok.Setter;

        import javax.persistence.*;
        import java.time.LocalTime;
>>>>>>> 79a0b908c4b665403b5fe0fc69cd1c64075e2f16

@Entity
@Getter
@Setter
@Table(name="\"blood_donation\"")
@Data
<<<<<<< HEAD
@AllArgsConstructor
@NoArgsConstructor
=======
>>>>>>> 79a0b908c4b665403b5fe0fc69cd1c64075e2f16
public class BloodDonation {

    @NonNull
    @Id
    @Column(name = "bd_id")
    private String bdId;

<<<<<<< HEAD
    @JoinColumn(name = "bdi_id")
    @ManyToOne
    private BloodInstitution bloodInstitution;
=======
    @Column(name = "bdi_id")
    private String bdiId;
>>>>>>> 79a0b908c4b665403b5fe0fc69cd1c64075e2f16

    @Column(name = "bd_type")
    private String bdType;

    @Column(name = "bd_amount")
    private int bdAmount;

<<<<<<< HEAD
    @CreationTimestamp
    @Column(name = "bd_date")
    private LocalDateTime bdDate;

    @Column(name = "bd_check")
    private int bdCheck;
=======
    @Column(name = "bd_date")
    private LocalTime bdDate;

    @Column(name = "bd_institute")
    private String bdInstitute;
>>>>>>> 79a0b908c4b665403b5fe0fc69cd1c64075e2f16

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

<<<<<<< HEAD
    @Column(name = "bd_donate")
    private String bdDonate;

=======
>>>>>>> 79a0b908c4b665403b5fe0fc69cd1c64075e2f16
    public String getBdId() {
        return bdId;
    }

    public void setBdId(String bdId) {
        this.bdId = bdId;
    }

<<<<<<< HEAD
    public BloodInstitution getBloodInstitution() {
        return bloodInstitution;
    }

    public void setBloodInstitution(BloodInstitution bloodInstitution) {
        this.bloodInstitution = bloodInstitution;
=======
    public String getBdiId() {
        return bdiId;
    }

    public void setBdiId(String bdiId) {
        this.bdiId = bdiId;
>>>>>>> 79a0b908c4b665403b5fe0fc69cd1c64075e2f16
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

<<<<<<< HEAD
    public LocalDateTime getBdDate() {
        return bdDate;
    }

    public void setBdDate(LocalDateTime bdDate) {
        this.bdDate = bdDate;
    }

    public int getBdCheck() {
        return bdCheck;
    }

    public void setBdCheck(int bdCheck) {
        this.bdCheck = bdCheck;
=======
    public LocalTime getBdDate() {
        return bdDate;
    }

    public void setBdDate(LocalTime bdDate) {
        this.bdDate = bdDate;
    }

    public String getBdInstitute() {
        return bdInstitute;
    }

    public void setBdInstitute(String bdInstitute) {
        this.bdInstitute = bdInstitute;
>>>>>>> 79a0b908c4b665403b5fe0fc69cd1c64075e2f16
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

<<<<<<< HEAD
    public String getBdDonate() {
        return bdDonate;
    }

    public void setBdDonate(String bdDonate) {
        this.bdDonate = bdDonate;
    }

=======
    //    public String getUser_id() {
//        return user_id;
//    }
//
//    public void setUser_id(String user_id) {
//        this.user_id = user_id;
//    }
>>>>>>> 79a0b908c4b665403b5fe0fc69cd1c64075e2f16
}
