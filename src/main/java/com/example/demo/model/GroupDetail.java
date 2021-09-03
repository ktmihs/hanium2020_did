package com.example.demo.model;

<<<<<<< HEAD
import lombok.*;
=======
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
>>>>>>> 79a0b908c4b665403b5fe0fc69cd1c64075e2f16

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
<<<<<<< HEAD
import java.io.Serializable;
=======
>>>>>>> 79a0b908c4b665403b5fe0fc69cd1c64075e2f16

@Entity
@Getter
@Setter
@Table(name="\"group_detail\"")
@Data
<<<<<<< HEAD
@AllArgsConstructor
@NoArgsConstructor
public class GroupDetail {
    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
=======
public class GroupDetail {
    @NonNull
    @Id
>>>>>>> 79a0b908c4b665403b5fe0fc69cd1c64075e2f16
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