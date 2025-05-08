package com.moliendafina.backend.controller;

import com.moliendafina.backend.model.OrderDetail;
import com.moliendafina.backend.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order-details")
public class OrderDetailController {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @GetMapping
    public List<OrderDetail> getAllOrderDetails() {
        return orderDetailRepository.findAll();
    }

    @GetMapping("/order/{orderId}")
    public List<OrderDetail> getDetailsByOrder(@PathVariable Long orderId) {
        return orderDetailRepository.findByOrderId(orderId);
    }

    @PostMapping
    public OrderDetail createOrderDetail(@RequestBody OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderDetail(@PathVariable Long id) {
        orderDetailRepository.deleteById(id);
    }

    @DeleteMapping
    public void deleteAllOrderDetails() {
        orderDetailRepository.deleteAll();
    }
}