package com.service;

import java.util.List;
import java.util.Optional;

import com.entity.Order;



public interface OrderService {
	public Order saveOrder(Order order);
	public Optional<Order> findOrderById(Long orderid);
	public List<Order> getAllOrders();
	public void deleteOrder(Long orderid);
}

