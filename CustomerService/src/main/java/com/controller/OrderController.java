package com.controller;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.entity.Billing;
import com.entity.MenuItem;
import com.entity.Order;
import com.service.OrderClientService;
import com.service.OrderServiceImpl;


@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;
    
    @Autowired
    RestTemplate restTemplate;
   
    @GetMapping("/getmenuitems")
    public ResponseEntity<List<MenuItem>>getMenuItems(){
    	String url="http://localhost:8050/menu/getitems";
        MenuItem[] itemsArray = restTemplate.getForObject(url, MenuItem[].class);    
    
         List<MenuItem> itemsList = Arrays.asList(itemsArray);
         return new ResponseEntity<>(itemsList, HttpStatus.OK);
    }

    @Autowired
    private OrderClientService orderClientService;

    @PostMapping("/create")
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order createdOrder = orderClientService.createOrder(order);
        return ResponseEntity.ok(createdOrder);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrderDetails(@PathVariable Long orderId) {
        Order order = orderClientService.getOrderDetails(orderId);
        if (order != null) {
            return ResponseEntity.ok(order);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{orderid}/generate-bill")
    public ResponseEntity<Billing> generateBill(@PathVariable Long orderid) {
      Billing bill=  orderClientService.generateBill(orderid);
        return ResponseEntity.ok(bill);
    }

    @DeleteMapping("/remove/{orderid}")
  
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderid) {
        if (orderService.findOrderById(orderid).isPresent()) {
            orderService.deleteOrder(orderid);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
