package com.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.MenuItem;
import com.service.MenuItemServiceImpl;

@RestController

@RequestMapping("/menu/")
public class MenuController {
	@Autowired
	MenuItemServiceImpl menuitemService;

	@PostMapping("/additem")
	public ResponseEntity<MenuItem>addmenuitem(@RequestBody MenuItem menuitem){
		MenuItem createitem=menuitemService.addMenuItem(menuitem);
		return new ResponseEntity<>(createitem,HttpStatus.CREATED);
	}
	@PutMapping("/updateitem")
	public ResponseEntity<MenuItem>updatemenuitem(@RequestBody MenuItem menuitem){
		MenuItem updateditem=menuitemService.updateMenuItem(menuitem);
		return new ResponseEntity<>(updateditem,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteitem/{itemid}")
	public ResponseEntity<Void>deletemenuitem(@PathVariable Long itemid){
		menuitemService.deleteMenuItem(itemid);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping("/getitem/{itemid}")
	public ResponseEntity<MenuItem> getmenuitembyId(@PathVariable Long itemid) {
	    Optional<MenuItem> item = menuitemService.getMenuItembyId(itemid);
	    if (item.isPresent()) {
	        return new ResponseEntity<>(item.get(), HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@GetMapping("/getitems")	
	public ResponseEntity<List<MenuItem>>getmenuitems(){
	List<MenuItem>items=menuitemService.getAllMenuItems();
		return new ResponseEntity<>(items,HttpStatus.OK);
	}
}

