package com.latihan.adi.controller;

import com.latihan.adi.entity.TblPenjualan;
import com.latihan.adi.pojo.PenjualanPojo;
import com.latihan.adi.service.PenjualanBarangService;
import com.latihan.adi.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("penjualan")
public class Penjualan {

    @Autowired
    private PenjualanBarangService penjualanBarangService;

    @PostMapping("add/penjualan")
    private ResponseEntity<MessageModel> addPenjualan(@RequestBody PenjualanPojo penjualanPojo) {
        ResponseEntity responseEntity = penjualanBarangService.addPenjualanBarang(penjualanPojo);
        return responseEntity;
    }
}
