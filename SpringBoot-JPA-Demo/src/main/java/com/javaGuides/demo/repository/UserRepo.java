package com.javaGuides.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaGuides.demo.entity.UserVO;

public interface UserRepo extends JpaRepository<UserVO, Integer>{

}
