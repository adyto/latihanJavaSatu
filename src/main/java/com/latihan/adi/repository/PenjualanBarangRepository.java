package com.latihan.adi.repository;

import com.latihan.adi.entity.TblPenjualan;
import com.latihan.adi.entity.TblUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface PenjualanBarangRepository extends JpaRepository<TblPenjualan, UUID> {
//@Query(value = "select * from tbl_users tu where name_user = :nameUser")
//TblUsers getRoleByName(@Param("nameUser") String nameUser);
}
