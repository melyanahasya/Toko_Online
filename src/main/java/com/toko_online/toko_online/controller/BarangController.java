package com.toko_online.toko_online.controller;

import com.toko_online.toko_online.model.Barang;
import com.toko_online.toko_online.response.CommonResponse;
import com.toko_online.toko_online.response.ResponeHelper;
import com.toko_online.toko_online.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Barang")
public class BarangController {
    @Autowired
    private BarangService barangService;

    @GetMapping("/all")
    public Object getAllBarang(){
        return ResponeHelper.ok(barangService.getAllBarang()) ;
    }

    @GetMapping("/{Id}")
    public Object getBarang(@PathVariable("Id") Long Id) {
        return ResponeHelper.ok(barangService.getBarang(Id));
    }

    @PostMapping
    public ResponseEntity<CommonResponse<Barang>> addBarang(@RequestBody Barang barang) {
        return ResponeHelper.ok(barangService.addBarang(barang));
    }

    @PutMapping("/{Id}")
    public ResponseEntity<CommonResponse<Barang>> editBarangById(@PathVariable("Id") Long Id, @RequestBody Barang barang) {
        return ResponeHelper.ok(barangService.editBarang(Id, barang.getName(), barang.getPrice(), barang.getCount(), barang.getReting(), barang.getDescription(), barang.getPublish()));
    }

    @DeleteMapping("/{Id}")
    public void deleteBarangById(@PathVariable("Id") Long Id) { barangService.deleteBarangById(Id);}
}

