package com.sumtechlabs.orderservice.controller;

import com.sumtechlabs.orderservice.entity.Order;
import com.sumtechlabs.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
		order = orderService.findOrderById(100L);
		//order.setAccount("David");
		//order.setId(100);
		if (order != null&&order.getAccount().contains("Rolls Royce")) {
			return new ResponseEntity<>(order, HttpStatus.OK);
		}
		return new ResponseEntity<>(order, HttpStatus.NOT_FOUND);
	}

	@GetMapping(path = "/api/orderservice/orders",  produces = { MediaType.APPLICATION_JSON_VALUE})
	public List<Order> getAllOrders() {
		return orderService.findAll();
	}


	@RequestMapping(path = "/api/orderservice/order/{orderId}", method= RequestMethod.GET)
	public ResponseEntity<Order> getOrderById(@PathVariable Long orderId) {
		Order orderSearchedById = orderService.findOrderById(orderId);
		if (orderSearchedById!=null) {
			return new ResponseEntity<>(orderSearchedById, HttpStatus.OK);
		}
		return new ResponseEntity<>(orderSearchedById, HttpStatus.NOT_FOUND);
	}


}
