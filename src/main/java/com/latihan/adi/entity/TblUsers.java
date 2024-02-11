package com.latihan.adi.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.UUID;

@Setter
@Getter
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_users", schema = "public")
public class TblUsers implements Serializable {
    @Id
    @Column(name = "id_user", nullable = false)
    private UUID idUser;

    @Column(name = "name_user")
    private String nameUser;

    @Column(name = "role")
    private String roleUser;
}
