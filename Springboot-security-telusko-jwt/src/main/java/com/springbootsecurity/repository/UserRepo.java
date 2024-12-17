package com.springbootsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootsecurity.model.UserInfo;

@Repository
public interface UserRepo extends JpaRepository<UserInfo, Integer>{

	UserInfo findByName(String userName);
		
}
