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
@Table(name="\"blood_institution\"")
@Data
public class blood_institution {
    @NonNull
    @Id
    @Column(name="bdi_id")
    private String bdi_id;
    @Id
    @Column(name="bdi_name")
    private String bdi_name;
    @Id
    @Column(name="bdi_phone")
    private String bdi_phone;
    @Id
    @Column(name="bdi_add")
    private String bdi_add;
    @Id
    @Column(name="bdi_inputdate")
    private LocalTime bdi_inputdate;

    public String getBdi_id() {
        return bdi_id;
    }

    public void setBdi_id(String bdi_id) {
        this.bdi_id = bdi_id;
    }

    public String getBdi_name() {
        return bdi_name;
    }

    public void setBdi_name(String bdi_name) {
        this.bdi_name = bdi_name;
    }

    public String getBdi_phone() {
        return bdi_phone;
    }

    public void setBdi_phone(String bdi_phone) {
        this.bdi_phone = bdi_phone;
    }

    public String getBdi_add() {
        return bdi_add;
    }

    public void setBdi_add(String bdi_add) {
        this.bdi_add = bdi_add;
    }

    public LocalTime getBdi_inputdate() {
        return bdi_inputdate;
    }

    public void setBdi_inputdate(LocalTime bdi_inputdate) {
        this.bdi_inputdate = bdi_inputdate;
    }
}
