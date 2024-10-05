package com.viewcontroller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.entity.Customer;
import com.entity.MenuItem;
import com.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerViewController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "register"; 
    }

    @PostMapping("/register")
    public String registerCustomer(@ModelAttribute("customer") Customer customer, Model model) {
        Customer registeredCustomer = customerService.registerCustomer(customer);
        model.addAttribute("customer", registeredCustomer);
        return "registrationSuccess";
    }
    
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("customer", new Customer()); 
        return "loginCustomer"; 
    }

    @PostMapping("/login")
    public String loginCustomer(@RequestParam String username, @RequestParam String password, Model model) {
        Optional<Customer> optionalCustomer=customerService.findByUsername(username);
        if (optionalCustomer.isPresent() && optionalCustomer.get().getPassword().equals(password)) {
            model.addAttribute("customer", optionalCustomer.get());
            return "CustomerUI"; 
        }
        else {
        	return "LoginCustomer2";
        }
    }

    @GetMapping("/home")
    public String showHomePage(Model model) {
        return "home"; 
    }
    @GetMapping("/home3")
    public String showHome3Page(Model model) {
        return "CustomerUI"; 
    }
    @GetMapping("/home2")
    public String showHome2Page(Model model) {
        return "PizzaUI"; 
    }
    @GetMapping("/Contact")
    public String showContactPage(Model model) {
        return "Contactjsp"; 
    }
    @GetMapping("/about")
    public String showAboutPage(Model model) {
        return "About"; 
    }
    @GetMapping("/logout")
    public String showLogOutPage(Model model) {
        return "Logout"; 
    }
    @GetMapping("/menu")
    public String showMenuPage(Model model) {
        return "Menu"; 
    }
    @GetMapping("/editMenu")
    public String showEditMenuPage(Model model) {
        return "EditMenu"; 
    }
    @GetMapping("/addItems")
    public String showAddItemsPage(Model model) {
    	model.addAttribute("addItems", new MenuItem());
        return "AddItems"; 
    }
    @GetMapping("/deleteItems")
    public String showDeleteItemsPage(Model model) {
        return "DeleteItems"; 
    }
    @GetMapping("/UpdateItems")
    public String showUpdateItemsPage(Model model) {
        return "UpdateItems"; 
    }
    
  
}

