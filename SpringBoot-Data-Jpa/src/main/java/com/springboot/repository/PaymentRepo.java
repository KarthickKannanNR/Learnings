package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.entity.PaymetVO;

@Repository
public interface PaymentRepo extends JpaRepository<PaymetVO, Integer>{

}
