package com.programmingtechie.inventoryService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.programmingtechie.inventoryService.dto.InventoryResponse;
import com.programmingtechie.inventoryService.service.InventoryService;

import jakarta.annotation.PostConstruct;

@RequestMapping("/api/inventory/")
@RestController
public class InventoryController {

	@Value("${server.port}")
	private int portNUm;
	
	@Autowired
	InventoryService inventoryService;
	
	@GetMapping("checkStock")
	public List<InventoryResponse> checkStockAvailability(@RequestParam List<String> skuCode) {
		System.out.println(portNUm);
		return inventoryService.checkStockAvailability(skuCode);
	}
	
}
