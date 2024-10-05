package com.service;

import com.entity.Billing;
import com.entity.Order;
public interface OrderService {
	public Order saveOrder(Order order);
	public Order findById(Long orderid);
	public void deleteOrder(Long orderid);
	public void acceptOrder(Long orderid);
	public void rejectOrder(Long orderid);
	public void updateOrderStatus(Long orderid, String status);
	public Double getMonthlyRevenue(int month, int year);
	public Billing generateBill(Long orderid);
	 
}

