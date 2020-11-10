package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name="\"group_detail\"")
@Data
public class GroupDetail implements Serializable {
    @NonNull
    @Id
    @Column(name = "gc_id")
    private String gcId;

    @Column(name = "gc_name")
    private String gcName;

    @ManyToOne
    @JoinColumn(name = "g_id")
    private Group group;

    public String getGcId() {
        return gcId;
    }

    public void setGcId(String gcId) {
        this.gcId = gcId;
    }

    public String getGcName() {
        return gcName;
    }

    public void setGcName(String gcName) {
        this.gcName = gcName;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}