

        package com.example.demo.model;

        import lombok.Data;
        import lombok.Getter;
        import lombok.NonNull;
        import lombok.Setter;

        import javax.persistence.*;
        import java.time.LocalTime;

@Entity
@Getter
@Setter
@Table(name="\"blood_donation\"")
@Data
public class BloodDonation {

    @NonNull
    @Id
    @Column(name = "bd_id")
    private String bdId;

    @Column(name = "bdi_id")
    private String bdiId;

    @Column(name = "bd_type")
    private String bdType;

    @Column(name = "bd_amount")
    private int bdAmount;

    @Column(name = "bd_date")
    private LocalTime bdDate;

    @Column(name = "bd_institute")
    private String bdInstitute;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

    public String getBdId() {
        return bdId;
    }

    public void setBdId(String bdId) {
        this.bdId = bdId;
    }

    public String getBdiId() {
        return bdiId;
    }

    public void setBdiId(String bdiId) {
        this.bdiId = bdiId;
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
