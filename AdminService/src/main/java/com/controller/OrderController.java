package com.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Billing;
import com.entity.Order;
import com.service.OrderServiceImpl;


@RestController
@RequestMapping("/api/orders")
public class OrderController {
	 @Autowired
	 private OrderServiceImpl orderService;

	 @PostMapping
	 public Order createOrder(@RequestBody Order order) {
	    return orderService.saveOrder(order);
	   }
	 @GetMapping("/{orderid}")
	  public Order getOrder(@PathVariable Long orderid) {
	     return orderService.findById(orderid);
	  }

	 @PutMapping("/{orderid}/accept")
	 public void acceptOrder(@PathVariable Long orderid) {
         orderService.acceptOrder(orderid);
	 }

    @PutMapping("/{orderid}/reject")
     public void rejectOrder(@PathVariable Long orderid) {
         orderService.rejectOrder(orderid);
	 }

    @PutMapping("/{orderid}/status")
	 public void updateOrderStatus(@PathVariable Long orderid, @RequestParam String status) {
	     orderService.updateOrderStatus(orderid, status);
	 }
    @DeleteMapping("/{orderid}")
    public void deleteOrder(@PathVariable Long orderid) {
        orderService.deleteOrder(orderid);
    }

    @PostMapping("/{orderid}/generate-bill")
    public Billing generateBill(@PathVariable Long orderid) {
       return orderService.generateBill(orderid);
    }

    @GetMapping("/revenue")
    public Double getMonthlyRevenue(@RequestParam int month, @RequestParam int year) {
        return orderService.getMonthlyRevenue(month, year);
    }

}
