package com.programmingtechie.inventoryService.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.programmingtechie.inventoryService.dto.InventoryResponse;
import com.programmingtechie.inventoryService.model.Inventory;
import com.programmingtechie.inventoryService.repository.InventoryRepository;

import jakarta.annotation.PostConstruct;

@Service
public class InventoryService {

	@Autowired
	InventoryRepository inventoryRepo;
	
	@Transactional(readOnly = true)
	public List<InventoryResponse> checkStockAvailability(List<String> skuCode) {
		return inventoryRepo.findByskuCodeIn(skuCode)
				            .stream()
				            .map(inventory -> new InventoryResponse(inventory.getSkuCode(),inventory.getQuantity() > 0))
				            .toList();
	}

	@PostConstruct
	public void addStock() {
		inventoryRepo.deleteAll();
		List<Inventory> inventoryList = Arrays.asList(
				new Inventory("reddragon kumara k552",100),
				new Inventory("GoForce 5W",20),
				new Inventory("reddregon keyboard",10),
				new Inventory("Portronic Mouse",76),
				new Inventory("Ajas night lamp",0)
		   );
		inventoryRepo.saveAll(inventoryList);	
	}

}
