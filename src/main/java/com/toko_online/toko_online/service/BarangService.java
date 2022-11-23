package com.toko_online.toko_online.service;

import com.toko_online.toko_online.model.Barang;

public interface BarangService {
   Object getAllBarang();
    Barang addBarang(Barang barang);

 Object getBarang(Long Id);

 Object getBarangById(Long id);

    Barang editBarang(Long Id, String name, Float price, Integer count, Integer reting, String description, Boolean publish);
    void deleteBarangById(Long Id);

}
