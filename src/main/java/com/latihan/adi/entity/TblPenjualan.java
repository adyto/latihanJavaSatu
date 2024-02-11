package com.latihan.adi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Table(name = "tbl_penjualan", schema = "public")
public class TblPenjualan implements Serializable {
    @Id
    @Column(name = "id_penjual", nullable = false)
    private UUID idPenjualan;

    @Column(name = "name_user")
    private String nameUser;

    @Column(name = "name_barang")
    private String nameBarang;

    @Column(name = "jumlah_barang")
    private Integer jumlahBarang;

    @Column(name = "harga_barang")
    private Double hargaBarang;
}
