package com.latihan.adi.service;

import com.latihan.adi.entity.TblPenjualan;
import com.latihan.adi.entity.TblStockBarang;
import com.latihan.adi.entity.TblUsers;
import com.latihan.adi.pojo.PenjualanPojo;
import com.latihan.adi.repository.PenjualanBarangRepository;
import com.latihan.adi.repository.StokBarangRepository;
import com.latihan.adi.repository.UserRepository;
import com.latihan.adi.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PenjualanBarangService {

    @Autowired
    private PenjualanBarangRepository penjualanBarangRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private  StokBarangRepository stokBarangRepository;

    @Transactional

    public ResponseEntity<MessageModel> addPenjualanBarang(PenjualanPojo penjualanPojo) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try {
            TblUsers nameUser = userRepository.getRoleByName(penjualanPojo.getNameUser());
            if( nameUser != null){
                System.out.println(nameUser.getRoleUser());
                System.out.println(nameUser);
                if(nameUser.getRoleUser().equals("penjual")) {
                    TblStockBarang nameBarang = stokBarangRepository.getBarangName(penjualanPojo.getNameBarang());
                    if(nameBarang != null) {
                        if(penjualanPojo.getJumlahBarang() == 0  || penjualanPojo.getHargaBarang() == 0) {
                            msg.setStatus(true);
                            msg.setMessage("Input angka Jumlah Barang & Harga Barang");
                            msg.setData(result);
                            return ResponseEntity.ok().body(msg);
                        } else {
                            if(penjualanPojo.getJumlahBarang() <= nameBarang.getStokBarang()) {
                                TblPenjualan tblPenjualan = new TblPenjualan();
                                tblPenjualan.setIdPenjualan(UUID.randomUUID());
                                tblPenjualan.setNameUser(penjualanPojo.getNameUser());
                                tblPenjualan.setNameBarang(penjualanPojo.getNameBarang());
                                tblPenjualan.setJumlahBarang(penjualanPojo.getJumlahBarang());
                                tblPenjualan.setHargaBarang(penjualanPojo.getHargaBarang());

                                int totalStock = nameBarang.getStokBarang() - penjualanPojo.getJumlahBarang();
                                String nameBarangSatu = penjualanPojo.getNameBarang();
                                penjualanBarangRepository.save(tblPenjualan);
//                                System.out.println();

                                stokBarangRepository.setStokBarang(totalStock, nameBarangSatu);
                                msg.setStatus(true);
                                msg.setMessage("Success Pembelian");
                                msg.setData(tblPenjualan);
                                return ResponseEntity.ok().body(msg);
                            } else {
                                msg.setStatus(true);
                                msg.setMessage("Stock Barang tersisa : " + nameBarang.getStokBarang());
                                msg.setData(result);
                                return ResponseEntity.ok().body(msg);
                            }
                        }
                    } else {
                        msg.setStatus(true);
                        msg.setMessage("Barang tidak tersedia!");
                        msg.setData(result);
                        return ResponseEntity.ok().body(msg);
                    }
                } else {
                    msg.setStatus(true);
                    msg.setMessage("User role bukan penjual, tidak bisa input data!");
                    msg.setData(result);
                    return ResponseEntity.ok().body(msg);
                }
            } else {
                msg.setStatus(true);
                msg.setMessage("User tidak terdaftar sebagai pembeli dan penjual");
                msg.setData(result);
                return ResponseEntity.ok().body(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        }
    }
}
