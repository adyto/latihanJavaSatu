package com.latihan.adi.service;

import com.latihan.adi.entity.TblStockBarang;
import com.latihan.adi.pojo.StokBarangPojo;
import com.latihan.adi.repository.StokBarangRepository;
import com.latihan.adi.utility.MessageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class StokBarangService {

    @Autowired
    private StokBarangRepository stokBarangRepository;

    public ResponseEntity<MessageModel> addStokBarang(StokBarangPojo stokBarangPojo) {
        Map<String, Object> result = new HashMap<>();
        MessageModel msg = new MessageModel();
        try {
            TblStockBarang tblStockBarang = new TblStockBarang();
            tblStockBarang.setIdBarang(UUID.randomUUID());
            tblStockBarang.setNameBarang(stokBarangPojo.getNamaBarang());
            tblStockBarang.setHargaBarang(stokBarangPojo.getHargaBarang());
            tblStockBarang.setStokBarang(stokBarangPojo.getStokBarang());

            stokBarangRepository.save(tblStockBarang);
            msg.setStatus(true);
            msg.setMessage("Success");
            result.put("Data", tblStockBarang);
            msg.setData(result);
            return ResponseEntity.status(HttpStatus.OK).body(msg);
        } catch (Exception e) {
            e.printStackTrace();
            msg.setStatus(false);
            msg.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
        }
    }
}
