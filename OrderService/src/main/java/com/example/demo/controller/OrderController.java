package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Order;
import com.example.demo.model.OrderItem;
import com.example.demo.service.OrderService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {org.springframework.web.bind.annotation.RequestMethod.GET, org.springframework.web.bind.annotation.RequestMethod.POST, org.springframework.web.bind.annotation.RequestMethod.PUT, org.springframework.web.bind.annotation.RequestMethod.DELETE, org.springframework.web.bind.annotation.RequestMethod.OPTIONS})
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	  @PostMapping("/orders/{userId}")
	    public Order placeOrder(@PathVariable int userId,@RequestBody List<OrderItem> items) {
	        return orderService.placeOrder(userId, items);
	    }

	    @GetMapping("/orders/users/{userId}")
	    public List<Order> getOrders(@PathVariable int userId) {
	        return orderService.getOrdersByUser(userId);
	    }

	    @GetMapping("/orders/{orderId}")
	    public List<OrderItem> getOrderItems(@PathVariable int orderId) {
	        return orderService.getOrderItems(orderId);
	    }
	    
	    @GetMapping("/orders/farmer/{farmerId}")
	    public List<OrderItem> getFarmerOrders(@PathVariable int farmerId) {
	        return orderService.getOrdersByFarmer(farmerId);
	    }
}
