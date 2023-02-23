package com.zyapaar.service;

import java.util.List;

import com.zyapaar.exception.InventoryException;
import com.zyapaar.model.Inventory;

public interface InventoryService {

	public Inventory createInventoryItem(Inventory item) throws InventoryException;
	public Inventory updateItemStatus(Inventory item) throws InventoryException;
	public List<Inventory> getAllInventoryDetails() throws InventoryException;
	public Inventory removeInventoryItem(Integer inventoryId) throws InventoryException;
	public String getInventoryStock(Integer inventoryId) throws InventoryException;
}
