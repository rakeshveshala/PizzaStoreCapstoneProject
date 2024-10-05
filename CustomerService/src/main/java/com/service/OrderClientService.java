package com.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.entity.Billing;
import com.entity.Order;


@Service
public class OrderClientService {

    @Autowired
    private RestTemplate restTemplate;

    private final String adminServiceUrl = "http://localhost:8050/api/orders"; 

    public Order createOrder(Order order) {
        return restTemplate.postForObject(adminServiceUrl, order, Order.class);
    }

    public Order getOrderDetails(Long orderId) {
        return restTemplate.getForObject(adminServiceUrl + "/" + orderId, Order.class);
    }

    public Billing generateBill(Long orderid) {
       return  restTemplate.postForObject(adminServiceUrl + "/" + orderid + "/generate-bill", orderid, Billing.class);
    }
}
