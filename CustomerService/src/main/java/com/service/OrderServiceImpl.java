package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Order;
import com.repository.OrderRepository;


@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
    private OrderRepository orderRepository;

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public Optional<Order> findOrderById(Long orderid) {
        return orderRepository.findById(orderid);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public void deleteOrder(Long orderid) {
        if (orderRepository.existsById(orderid)) {
            orderRepository.deleteById(orderid);
        }
    }
}
