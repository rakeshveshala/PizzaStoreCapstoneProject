package com.viewcontroller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.entity.Customer;
import com.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerViewController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "register"; // Maps to `register.jsp`
    }

    @PostMapping("/register")
    public String registerCustomer(@ModelAttribute("customer") Customer customer, Model model) {
        Customer registeredCustomer = customerService.registerCustomer(customer);
        model.addAttribute("customer", registeredCustomer);
        return "registrationSuccess"; // Maps to a success page `registrationSuccess.jsp`
    }
    
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("customer", new Customer()); // Use Customer as a model attribute for the login form
        return "loginCustomer"; // Maps to `loginCustomer.jsp`
    }

    @PostMapping("/login")
    public String loginCustomer(@RequestParam String username, @RequestParam String password, Model model) {
        //Optional<Customer> optionalCustomer = customerService.findByUsername(username);
        Optional<Customer> optionalCustomer=customerService.findByUsername(username);
        if (optionalCustomer.isPresent() && optionalCustomer.get().getPassword().equals(password)) {
            model.addAttribute("customer", optionalCustomer.get());
            return "CustomerUI"; // Maps to `customerHome.jsp`
        }
        else {
        	return "LoginCustomer2";
        }
    }

    @GetMapping("/home")
    public String showHomePage(Model model) {
        return "home"; // Maps to `customerHome.jsp`, the main dashboard or homepage
    }

    @GetMapping("/{id}")
    public String getCustomerById(@PathVariable Long id, Model model) {
        Customer customer = customerService.getCustomerById(id);
        if (customer != null) {
            model.addAttribute("customer", customer);
            return "customerDetails"; // Maps to `customerDetails.jsp`
        }
        return "error"; // Maps to an error page if the customer is not found
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Customer customer = customerService.getCustomerById(id);
        if (customer != null) {
            model.addAttribute("customer", customer);
            return "updateCustomer"; // Maps to `updateCustomer.jsp`
        }
        return "error"; // Maps to an error page if the customer is not found
    }

    @PostMapping("/update/{id}")
    public String updateCustomer(@PathVariable Long id, @ModelAttribute("customer") Customer customer, Model model) {
        customer.setId(id);
        Customer updatedCustomer = customerService.updateCustomer(customer);
        if (updatedCustomer != null) {
            model.addAttribute("customer", updatedCustomer);
            return "customerDetails"; // Maps to `customerDetails.jsp`
        }
        return "error"; // Maps to an error page if the update fails
    }
    @GetMapping("/service")
    public String showServicePage(Model model) {
        return "Service"; 
    }
    @GetMapping("/adminlogin")
    public String showadminPage(Model model) {
        return "login"; 
    }
    @GetMapping("/logoutcust")
    public String showLogoutPage(Model model) {
        return "Logout"; 
    }
    @GetMapping("/home2")
    public String showHome2Page(Model model) {
        return "CustomerUI"; 
    }
    @GetMapping("/menu")
    public String showMenuPage(Model model) {
        return "Menu"; 
    }
    @GetMapping("/contact")
    public String showContactPage(Model model) {
        return "Contact"; 
    }
    @GetMapping("/about")
    public String showAboutPage(Model model) {
        return "About"; 
    }

  
}

