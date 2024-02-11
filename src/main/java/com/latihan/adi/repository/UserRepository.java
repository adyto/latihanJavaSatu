package com.latihan.adi.repository;

import com.latihan.adi.entity.TblUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface UserRepository extends JpaRepository<TblUsers, Long> {
    @Query(value = "select * from tbl_users tu where tu.name_user = :nameUser", nativeQuery = true)
    TblUsers getRoleByName(@Param("nameUser") String nameUser);

}
