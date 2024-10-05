package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Customer;
import com.repository.CustomerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    

    @Transactional
    public Customer registerCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
  

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);    
    }

    public Customer getCustomerByUsername(String username) {
        return customerRepository.findByUsername(username);
    }

    public Customer getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    @Transactional
    public Customer updateCustomer(Customer customer) {
        if (customerRepository.existsById(customer.getId())) {
            return customerRepository.save(customer);
        }
        return null;
    }
    


    
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    
    @Transactional
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }


    public Optional<Customer> findByUsername(String username) {
        return Optional.ofNullable(customerRepository.findByUsername(username));
    }
}
