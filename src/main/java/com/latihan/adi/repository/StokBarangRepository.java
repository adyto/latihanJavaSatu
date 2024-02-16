package com.latihan.adi.repository;

import com.latihan.adi.entity.TblStockBarang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;


public interface StokBarangRepository extends JpaRepository<TblStockBarang, UUID> {

    @Query(value = "select * from tbl_stok_barang tsb where name_barang ilike :nameBarang", nativeQuery = true)
    TblStockBarang getBarangName(@Param("nameBarang") String nameBarang);

    @Modifying
    @Query(value = "update tbl_stok_barang set stok_barang = :stokBarang where name_barang ilike :nameBarang", nativeQuery = true)
    void setStokBarang(@Param("stokBarang") Integer stokBarang, @Param("nameBarang") String nameBarang);


}
