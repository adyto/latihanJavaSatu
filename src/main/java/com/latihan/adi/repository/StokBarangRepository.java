package com.latihan.adi.repository;

import com.latihan.adi.entity.TblStockBarang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface StokBarangRepository extends JpaRepository<TblStockBarang, Long> {
    @Query(value = "select * from tbl_stok_barang tsb where name_barang ilike :nameBarang", nativeQuery = true)
    TblStockBarang getBarangName(@Param("nameBarang") String nameBarang);
}
