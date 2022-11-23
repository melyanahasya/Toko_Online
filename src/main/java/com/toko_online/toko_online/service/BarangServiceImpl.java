package com.toko_online.toko_online.service;

import com.toko_online.toko_online.exception.InternalErrorException;
import com.toko_online.toko_online.exception.NotFoundException;
import com.toko_online.toko_online.model.Barang;
import com.toko_online.toko_online.repository.BarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BarangServiceImpl implements BarangService {
    @Autowired
    BarangRepository barangRepository;


    @Override
    public Object getAllBarang() {
        return barangRepository.findAll();
    }

    @Override
    public Barang addBarang(Barang barang) {
        return barangRepository.save(barang);
    }


    @Override
    public Object getBarang(Long Id) {
        var barang = barangRepository.findById(Id).orElseThrow(() -> new NotFoundException("Id tidak ditemukan"));
        try {
            return barangRepository.save(barang);
        } catch (Exception e) {
            throw new InternalErrorException("Kesalahan memunculkan data");
        }
    }

    @Override
    public Object getBarangById(Long id) {
        return barangRepository.findById(id).get();
    }

    @Override
    public Barang editBarang(Long id, String name, Float price, Integer count, Integer rating, String description, Boolean publish) {
        Barang barang = barangRepository.findById(id).get();
        barang.setName(name);
        barang.setPrice(Float.valueOf(price));
        barang.setCount(Integer.valueOf(count));
        barang.setReting(Integer.valueOf(rating));
        barang.setDescription(description);
        barang.setPublish(Boolean.valueOf(publish));
        return barangRepository.save(barang);
    }

    @Override
    public void deleteBarangById(Long Id) {
        barangRepository.deleteById(Id);
    }
}
