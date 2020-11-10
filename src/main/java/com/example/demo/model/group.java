package com.example.demo.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name="\"group\"")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group {
    @NonNull
    @Id
    @Column(name = "g_id")
    private String gId;

    @Column(name = "g_name")
    private String gName;


    public String getgId() {
        return gId;
    }

    public void setgId(String gId) {
        this.gId = gId;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }
}