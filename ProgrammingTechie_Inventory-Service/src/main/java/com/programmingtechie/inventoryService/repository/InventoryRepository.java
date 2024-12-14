package com.programmingtechie.inventoryService.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.programmingtechie.inventoryService.model.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {

	public Optional<Inventory> findByskuCode(String skuCode);
}
