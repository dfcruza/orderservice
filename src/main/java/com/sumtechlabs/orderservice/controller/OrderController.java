package com.sumtechlabs.orderservice.controller;

import com.sumtechlabs.orderservice.entity.Order;
import com.sumtechlabs.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sumtechlabs.orderservice.entity.IEntity;

import java.util.List;


@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;

	@GetMapping(path = "/api/orderservice/order",  produces = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<IEntity> getOrderData() {

		Order order = new Order();
		//TODO: Complete the code according what we request.
		//1 - Create a Collection of Orders
		//2 - Retrieve Order Entity info by Id number 100 .
		//3 - Filter Order by Client.
		//4 - Validate 
		order.setAccount("David");
		order.setId(100);

		return new ResponseEntity<>(order, HttpStatus.OK);
	}

	@GetMapping(path = "/api/orderservice/orders",  produces = { MediaType.APPLICATION_JSON_VALUE})
	public List<Order> getAllOrders() {

		return orderService.findAll();
	}


}
