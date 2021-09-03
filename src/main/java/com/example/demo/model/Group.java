package com.example.demo.model;

<<<<<<< HEAD
import lombok.*;
=======
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
>>>>>>> 79a0b908c4b665403b5fe0fc69cd1c64075e2f16

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
<<<<<<< HEAD
import java.io.Serializable;
=======
>>>>>>> 79a0b908c4b665403b5fe0fc69cd1c64075e2f16

@Entity
@Getter
@Setter
@Table(name="\"group\"")
@Data
<<<<<<< HEAD
@AllArgsConstructor
@NoArgsConstructor
=======
>>>>>>> 79a0b908c4b665403b5fe0fc69cd1c64075e2f16
public class Group {
    @NonNull
    @Id
    @Column(name = "g_id")
    private String gId;

    @Column(name = "g_name")
    private String gName;

<<<<<<< HEAD

=======
>>>>>>> 79a0b908c4b665403b5fe0fc69cd1c64075e2f16
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