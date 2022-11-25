package com.toko_online.toko_online.service;

import com.toko_online.toko_online.model.Order;

public interface OrderService {
    Object getAllOrder();

    Order addOrder (Order order);

    Order getOrder(long Id);

    Object getOrder(Long Id);

    Object getOrderById(Long id);

    Order editOrder (Long Id, String namaBarang, Float harga, String pemilik);

    void deleteOrderById(Long Id);
}
