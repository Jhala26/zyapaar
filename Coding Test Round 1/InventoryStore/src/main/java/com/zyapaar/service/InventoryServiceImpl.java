package com.zyapaar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zyapaar.exception.InventoryException;
import com.zyapaar.model.Inventory;
import com.zyapaar.repository.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService{

	@Autowired
	private InventoryRepository iRepo;

	
	
	@Override
	public Inventory createInventoryItem(Inventory item) throws InventoryException {
		
		Inventory inventory =  iRepo.save(item);
		
		return inventory;
	}

	@Override
	public Inventory updateItemStatus(Inventory item) throws InventoryException {
		
		Optional<Inventory> opt = iRepo.findById(item.getInventoryId());
		
		if(opt.isPresent()) {
			
			Inventory inven = opt.get();
			
			if(item.getInventory_Name() != null) inven.setInventory_Name(item.getInventory_Name());
			if(item.getInventory_desc() != null) inven.setInventory_desc(item.getInventory_desc());
			if(item.getInventory_quantity() != null) inven.setInventory_quantity(item.getInventory_quantity());
			if(item.getInventory_status() != null) inven.setInventory_status(item.getInventory_status());
		
			
			Inventory inventory = iRepo.save(inven);
			
			return inventory;
		
		}
		else {
			
			throw new InventoryException("Inventory Not Found");
		}
		
	
	}

	@Override
	public List<Inventory> getAllInventoryDetails() throws InventoryException {
		
		List<Inventory> allInventory = iRepo.findAll();
		
		if(allInventory.isEmpty()) {
			
	    throw new InventoryException("Inventory List is Empty");
		}
		else {
			
			return allInventory;
		}
		
		
	}

	@Override
	public Inventory removeInventoryItem(Integer inventoryId) throws InventoryException {
		
		Optional<Inventory> opt = iRepo.findById(inventoryId);
		
		if(opt.isPresent()) {
			
			Inventory inven = opt.get();
			
			iRepo.delete(inven);
		
			return inven;
		}
		else {
			
			throw new InventoryException("Inventory Not Found");
		}
		
		
	}

	@Override
	public String getInventoryStock(Integer inventoryId) throws InventoryException {
		
		Optional<Inventory> opt = iRepo.findById(inventoryId);

		if(opt.isPresent()) {
			
			Inventory inven = opt.get();
			
			if(inven.getInventory_quantity() == 0) {
				
				return  "Inventory is Empty";
				
			}
			else {
				
				return "The size of the Inventory is : " + inven.getInventory_quantity();
			}
			
			
		}
		else {
			
			throw new InventoryException("Inventory Not Found");
		}
		


	}
	
	
}
