package com.sumtechlabs.orderservice.service;

import com.sumtechlabs.orderservice.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        List<Order> orders = orderRepository.findAll();
        return orders;
    }
}
