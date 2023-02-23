package com.zyapaar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zyapaar.model.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer>{

	
	
}
