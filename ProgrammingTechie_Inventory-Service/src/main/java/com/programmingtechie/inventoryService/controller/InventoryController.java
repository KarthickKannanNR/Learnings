package com.programmingtechie.inventoryService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.programmingtechie.inventoryService.service.InventoryService;

import jakarta.annotation.PostConstruct;

@RequestMapping("/api/inventory/")
@RestController
public class InventoryController {

	@Autowired
	InventoryService inventoryService;
	
	@GetMapping("checkStock")
	public boolean checkStockAvailability(@RequestParam String productName) {
		return inventoryService.checkStockAvailability(productName);
	}
	
}
