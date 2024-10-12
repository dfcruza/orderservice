package com.sumtechlabs.orderservice.service;

import com.sumtechlabs.orderservice.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        List<Order> orders = orderRepository.findAll();
        return orders;
    }

    public Order findOrderById(Long id) {
        Order orderSearched = new Order();//Crear orden buscada
        Optional<Order> OrderFound = orderRepository.findById(id); //Busco la orden en el repository
        if (OrderFound.isPresent()) {
            orderSearched.setId(OrderFound.get().getId());//Set
            orderSearched.setAccount(OrderFound.get().getAccount());
            return orderSearched;
        }
        return null;
    }
}
