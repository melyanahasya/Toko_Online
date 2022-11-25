package com.toko_online.toko_online.model;

import com.toko_online.toko_online.editing.Edit;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order extends Edit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "namaBarang", nullable = false)
    private String namaBarang;

    @Column(name = "harga")
    private Float harga;

    @Column(name = "pemilik", nullable = false)
    private String pemilik;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public Float getHarga() {
        return harga;
    }

    public void setHarga(Float harga) {
        this.harga = harga;
    }

    public String getPemilik() {
        return pemilik;
    }

    public void setPemilik(String pemilik) {
        this.pemilik = pemilik;
    }
}
