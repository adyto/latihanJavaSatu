package com.latihan.adi.controller;

import com.latihan.adi.pojo.StokBarangPojo;
import com.latihan.adi.service.StokBarangService;
import com.latihan.adi.utility.MessageModel;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("stok-barang")
public class StokBarang {

    @Autowired
    private StokBarangService stokBarangService;

    @PostMapping("add/barang")
    private ResponseEntity<MessageModel> addBarang(@RequestBody StokBarangPojo stokBarangPojo) {
        ResponseEntity responseEntity = stokBarangService.addStokBarang(stokBarangPojo);
        return responseEntity;
    }
}
