package com.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.MenuItem;
import com.repository.MenuItemRepository;

@Service
public class MenuItemServiceImpl implements MenuItemService{
	@Autowired
	private MenuItemRepository menuItemRepository;
	public MenuItem addMenuItem(MenuItem menuItem) {
	return menuItemRepository.save(menuItem);
	}
	
	public MenuItem updateMenuItem(MenuItem menuItem) {
	return menuItemRepository.save(menuItem);
	}
	
	public void deleteMenuItem(Long itemid) {
	menuItemRepository.deleteById(itemid);
	}
	
	public Optional<MenuItem> getMenuItembyId(Long itemid) {
	return menuItemRepository.findById(itemid);
	}
	
	public List<MenuItem> getAllMenuItems() {
	return menuItemRepository.findAll();
	}
}
