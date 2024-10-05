package com.dto;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class BillingDTO {
	
	private Long id;    
    private Long orderId;   
    private Double amount;    
    private String status;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date generatedAt;
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getGeneratedAt() {
		return generatedAt;
	}
	public void setGeneratedAt(Date generatedAt) {
		this.generatedAt = generatedAt;
	}
    
    
}
