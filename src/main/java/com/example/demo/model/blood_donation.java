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
@Table(name="\"blood_donation\"")
@Data
public class blood_donation {
    @NonNull
    @Id
    @Column(name="bd_id")
    private String bd_id;
    @Id
    @Column(name="bdi_id")
    private String bdi_id;
    @Id
    @Column(name="bd_type")
    private String bd_type;
    @Id
    @Column(name="bd_amount")
    private int bd_amount;
    @Id
    @Column(name="bd_date")
    private LocalTime bd_date;
    @Id
    @Column(name="bd_institute")
    private String bd_institute;
    @Id
    @Column(name="user_id")
    private String user_id;

    public String getBd_id() {
        return bd_id;
    }

    public void setBd_id(String bd_id) {
        this.bd_id = bd_id;
    }

    public String getBdi_id() {
        return bdi_id;
    }

    public void setBdi_id(String bdi_id) {
        this.bdi_id = bdi_id;
    }

    public String getBd_type() {
        return bd_type;
    }

    public void setBd_type(String bd_type) {
        this.bd_type = bd_type;
    }

    public int getBd_amount() {
        return bd_amount;
    }

    public void setBd_amount(int bd_amount) {
        this.bd_amount = bd_amount;
    }

    public LocalTime getBd_date(){
        return bd_date;
    }

    public void setBd_date(LocalTime bd_date){
        this.bd_date=bd_date;
    }

    public String getBd_institute() {
        return bd_institute;
    }

    public void setBd_institute(String bd_institute) {
        this.bd_institute = bd_institute;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
}
