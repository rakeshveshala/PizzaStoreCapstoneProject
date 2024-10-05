package com.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Billing;



public interface BillingRepository extends JpaRepository<Billing,Long> {

	Billing save(Billing bill);

}
