package com.toko_online.toko_online.repository;

import com.toko_online.toko_online.model.Barang;
import com.toko_online.toko_online.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BarangRepository extends JpaRepository<Barang, Long> {

}

