package com.zyapaar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zyapaar.exception.InventoryException;
import com.zyapaar.model.Inventory;
import com.zyapaar.service.InventoryService;

@RestController
public class InventoruController {

	@Autowired
	private InventoryService iService;
	
	
	@PostMapping("/add")
	public ResponseEntity<Inventory> createInventoryItemHandler(@RequestBody Inventory inventory)throws InventoryException{
		
		
		Inventory inven = iService.createInventoryItem(inventory);
		
		return new ResponseEntity<Inventory>(inven, HttpStatus.CREATED);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<Inventory> updateItemStatusHandler(@RequestBody Inventory inventory)throws InventoryException{
		
		
		Inventory inven = iService.updateItemStatus(inventory);
		
		return new ResponseEntity<Inventory>(inven, HttpStatus.OK);
		
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Inventory>> getAllInventoryDetailsHandler()throws InventoryException{
		
		
		List<Inventory> inven = iService.getAllInventoryDetails();
		
		return new ResponseEntity<List<Inventory>>(inven, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Inventory> removeInventoryItemHandler(@PathVariable("id") Integer inventoryId)throws InventoryException{
		
		
		Inventory inven = iService.removeInventoryItem(inventoryId);
		
		return new ResponseEntity<Inventory>(inven, HttpStatus.OK);
		
	}
	
	@GetMapping("/getstock/{id}")
	public ResponseEntity<String> getInventoryStockHandler(@PathVariable("id") Integer inventoryId)throws InventoryException{
		
		
		String inven = iService.getInventoryStock(inventoryId);
		
		return new ResponseEntity<String>(inven, HttpStatus.OK);
		
	}
	
	
}
