package com.sumtechlabs.orderservice.service;

import com.sumtechlabs.orderservice.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findOrderById(Long pId) {
        Order orderSearched = new Order();//Crear orden buscada
        Optional<Order> OrderFound = orderRepository.findById(pId); //Busco la orden en el repository
        if (OrderFound.isPresent()) {
            orderSearched.setId(OrderFound.get().getId());//Set
            orderSearched.setAccount(OrderFound.get().getAccount());
            return orderSearched;
        }
        return null;
    }

    public List<Order> findByAccount(String pAccount) {
        List<Order> ordersByAccount = new ArrayList<>();

        return ordersByAccount;
    }
}
