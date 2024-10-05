package com.entity;



import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "bills")
public class Billing {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(nullable = false)
    private Long orderId;

    @Column(nullable = false)
    private Double amount;
    @Column(nullable = false)
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
