package com.programmingtechie.productService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.programmingtechie.productService.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
