package com.telusko.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.telusko.demo.Users;


public interface UsersDao extends JpaRepository<Users, Integer>{

	List<Users> findByLocation(String location);
	
	List<Users> findByUserIdGreaterThan(int userId);
	
//	@Query("from users where location = ?1")
//	List<Users> findByLocationSorted(String location);

}
