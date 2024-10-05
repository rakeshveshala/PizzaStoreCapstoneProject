package com.service;


import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Billing;
import com.entity.Order;
import com.repository.BillingRepository;
import com.repository.OrderRepository;


@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BillingRepository billingRepository;

    @Autowired
    private NotificationService notificationService;

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order findById(Long orderid) {
        return orderRepository.findById(orderid).orElse(null);
    }

    public void deleteOrder(Long orderid) {
        orderRepository.deleteById(orderid);
    }
    public void acceptOrder(Long orderid) {
        Order order = findById(orderid);
        if (order != null) {
            order.setStatus("Accepted");
            saveOrder(order);
            notificationService.notifyUser(order.getUserId(), "Your order has been accepted.");
        }
    }

    public void rejectOrder(Long orderid) {
        Order order = findById(orderid);
        if (order != null) {
            order.setStatus("Rejected");
            saveOrder(order);
            notificationService.notifyUser(order.getUserId(), "Your order has been rejected.");
        }
    }
    public void updateOrderStatus(Long orderid, String status) {
        Order order = findById(orderid);
        if (order != null) {
            order.setStatus(status);
            saveOrder(order);
            notificationService.notifyUser(order.getUserId(), "Your order status has been updated to " + status + ".");
        }
    }

    public Billing generateBill(Long orderid) {
        Order order = findById(orderid);
        if (order != null) {
            Billing bill = new Billing();
            bill.setOrderId(orderid);
            bill.setAmount(order.getTotalAmount());
            bill.setStatus("Generated");
            bill.setGeneratedAt(new Date());
          return  billingRepository.save(bill);
            
      

       }
		return null;
    }
    public Double getMonthlyRevenue(int month, int year) {
        Calendar start = Calendar.getInstance();
        start.set(year, month - 1, 1, 0, 0, 0);
        start.set(Calendar.MILLISECOND, 0);

        Calendar end = Calendar.getInstance();
        end.set(year, month, 1, 0, 0, 0);
        end.set(Calendar.MILLISECOND, 0);
        end.add(Calendar.DAY_OF_MONTH, -1);

        Date startDate = start.getTime();
        Date endDate = end.getTime();

        return orderRepository.calculateMonthlyRevenue(startDate, endDate);
    }
}
