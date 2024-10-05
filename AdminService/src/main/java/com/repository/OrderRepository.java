package com.repository;



import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.entity.Order;



public interface OrderRepository extends JpaRepository<Order,Long>{
	 @Query("SELECT SUM(o.totalAmount) FROM Order o WHERE o.status = 'Completed' AND o.createdAt BETWEEN :startDate AND :endDate")
	  Double calculateMonthlyRevenue(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
