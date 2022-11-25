package com.toko_online.toko_online.controller;

import com.toko_online.toko_online.dto.OrderDTO;
import com.toko_online.toko_online.model.Order;
import com.toko_online.toko_online.response.CommonResponse;
import com.toko_online.toko_online.response.ResponeHelper;
import com.toko_online.toko_online.service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/all")
    public Object getAllorder() {
        return ResponeHelper.ok(orderService.getAllOrder());
    }

    @GetMapping("/{Id}")
    public Object getOrder(@PathVariable("Id") Long Id) {
        return ResponeHelper.ok(orderService.getOrder(Id));
    }

    @PostMapping
    public ResponseEntity<CommonResponse<Order>> addOrder(@RequestBody OrderDTO orderDTO) {
     return ResponeHelper.ok(orderService.addOrder(modelMapper.map(orderDTO, Order.class)));
    }

    @PutMapping("/{Id}")
    public ResponseEntity<CommonResponse<Order>> editOrderById(@PathVariable("Id") Long Id, @RequestBody Order order) {
        return ResponeHelper.ok(orderService.editOrder(Id,order.getNamaBarang(),order.getHarga(),order.getPemilik()));
    }

    @DeleteMapping("/{Id}")
    public void deleteOrderById(@PathVariable("Id") Long Id) {
        orderService.deleteOrderById(Id);
    }
}
