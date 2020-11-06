package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Table(name="\"blood_institution\"")
@Data
public class BloodInstitution {
    @NonNull
    @Id
    @Column(name = "bdi_id")
    private String bdiId;

    @Column(name = "bdi_name")
    private String bdiName;

    @Column(name = "bdi_phone")
    private String bdiPhone;

    @Column(name = "bdi_add")
    private String bdiAdd;

    @Column(name = "bdi_inputdate")
    private LocalTime bdiInputdate;

    public String getBdiId() {
        return bdiId;
    }

    public void setBdiId(String bdiId) {
        this.bdiId = bdiId;
    }

    public String getBdiName() {
        return bdiName;
    }

    public void setBdiName(String bdiName) {
        this.bdiName = bdiName;
    }

    public String getBdiPhone() {
        return bdiPhone;
    }

    public void setBdiPhone(String bdiPhone) {
        this.bdiPhone = bdiPhone;
    }

    public String getBdiAdd() {
        return bdiAdd;
    }

    public void setBdiAdd(String bdiAdd) {
        this.bdiAdd = bdiAdd;
    }

    public LocalTime getBdiInputdate() {
        return bdiInputdate;
    }

    public void setBdiInputdate(LocalTime bdiInputdate) {
        this.bdiInputdate = bdiInputdate;
    }
}