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
@Table(name = "tbl_stok_barang", schema = "public")
public class TblStockBarang implements Serializable {
    @Id
    @Column(name = "id_barang", nullable = false)
    private UUID idBarang;

    @Column(name = "name_barang")
    private String nameBarang;

    @Column(name = "harga_barang")
    private Double hargaBarang;

    @Column(name = "stok_barang")
    private Integer stokBarang;
}
