package com.controller;

import com.entity.Admin;
import com.service.AdminService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admins")
public class AdminController {
	  @Autowired
    private final AdminService adserv;

 
    public AdminController(AdminService adminService) {
        this.adserv = adminService;
    }
    
    @Autowired
	RestTemplate restTemplate;

    @PostMapping("/register")
    public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) {
        Admin savedAdmin = adserv.saveAdmin(admin);
        return new ResponseEntity<>(savedAdmin, HttpStatus.CREATED);
    }

    @GetMapping("/getbyId/{id}")
    public ResponseEntity<Admin> getAdminById(@PathVariable("id") Long id) {
        Optional<Admin> admin = adserv.getAdminById(id);
        return admin.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


   
}