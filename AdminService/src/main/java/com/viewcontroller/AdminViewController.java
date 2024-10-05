package com.viewcontroller;

import com.entity.Admin;

import com.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminViewController {

    @Autowired
    private AdminService adminService;

   
    @RequestMapping("/Check")
   	public ModelAndView displayForm() {
   		return new ModelAndView("login", "checkObj", new Admin());
   	}

   	@RequestMapping(value = "/checkAdmin", method = RequestMethod.POST)
   	public String insertMovie(@ModelAttribute("checkObj") Admin val) {
   		//System.out.println(val.getPassword());
   		//System.out.println(val.getEmail());
   		if((val.getUsername().equalsIgnoreCase("host@123")) && (val.getPassword().equalsIgnoreCase("pizza123"))) {
   			return "PizzaUI";
   		}
   		return "login2";
   	}
    
    @GetMapping("/home")
    public String showHomePage(Model model) {
        return "home"; 
    }


}
