package com.toko_online.toko_online.repository;

import com.toko_online.toko_online.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order, Long> {

    // orders itu adalah name dari model order
    @Query(value = "select * from orders where pemilik = :email", nativeQuery = true)
    Optional<Order> findByPemilik(String email);
}
