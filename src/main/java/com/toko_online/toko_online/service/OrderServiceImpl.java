package com.toko_online.toko_online.service;

import com.toko_online.toko_online.exception.InternalErrorException;
import com.toko_online.toko_online.exception.NotFoundException;
import com.toko_online.toko_online.model.Order;
import com.toko_online.toko_online.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Override
    public Object getAllOrder() {
        return orderRepository.findAll();
    }

    @Override
    public Order addOrder(Order order) {
        if (orderRepository.findByPemilik(order.getPemilik()).isPresent()) {
            throw new InternalErrorException("Sudah digunakan");
        }
        return orderRepository.save(order);

    }

    @Override
    public Order getOrder(long Id) {
        return null;
    }

    @Override
    public Object getOrder(Long Id) {
        var order = orderRepository.findById(Id).orElseThrow(() -> new NotFoundException("Id tidak ditemukan"));
        try {
            return orderRepository.save(order);
        }catch (Exception e) {
            throw new InternalErrorException("Kesalahan memunculkan data");
        }
    }

    @Override
    public Object getOrderById(Long id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public Order editOrder(Long Id, String namaBarang,Float harga, String pemilik) {
        Order order = orderRepository.findById(Id).get();
        order.setNamaBarang(namaBarang);
        order.setHarga(Float.valueOf(harga));
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrderById(Long Id) {
        orderRepository.deleteById(Id);
    }
}
