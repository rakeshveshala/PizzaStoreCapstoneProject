package com.service;



import java.util.List;

import java.util.Optional;

import com.entity.MenuItem;



public interface MenuItemService {
	public MenuItem addMenuItem(MenuItem menuItem);
	public MenuItem updateMenuItem(MenuItem menuItem);
	public void deleteMenuItem(Long itemid);
	public Optional<MenuItem> getMenuItembyId(Long itemid);
	public List<MenuItem> getAllMenuItems();
}

