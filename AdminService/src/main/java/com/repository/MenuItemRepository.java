package com.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.MenuItem;


@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem,Long> {

}
