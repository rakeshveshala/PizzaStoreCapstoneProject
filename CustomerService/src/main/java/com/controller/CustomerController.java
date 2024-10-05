package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.entity.Customer;
import com.service.CustomerService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService custserv;
    
    @Autowired
   	RestTemplate restTemplate;


    @PostMapping("/registerCustomer")
    public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) {
        Customer registeredCustomer = custserv.registerCustomer(customer);
        return new ResponseEntity<>(registeredCustomer, HttpStatus.CREATED);
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        Customer customer = custserv.getCustomerById(id);
        if (customer != null) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/updateCustomerbyid/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        customer.setId(id);
        Customer updatedCustomer = custserv.updateCustomer(customer);
        if (updatedCustomer != null) {
            return new ResponseEntity<>(updatedCustomer, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    
    @GetMapping("/retreiveallCustomers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = custserv.getAllCustomers();
        if (!customers.isEmpty()) {
            return new ResponseEntity<>(customers, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
   @DeleteMapping("/deleteCustomer/{id}")
  public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
	   custserv.deleteCustomer(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
  
}
