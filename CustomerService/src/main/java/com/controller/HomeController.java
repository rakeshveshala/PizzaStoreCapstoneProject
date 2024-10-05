package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admins")
public class HomeController {
    
    @GetMapping("/home")
    public String showAdminHomePage() {
        return "adminHome";  
    }
}

