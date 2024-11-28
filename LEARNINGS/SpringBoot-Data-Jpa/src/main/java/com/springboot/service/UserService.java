package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.springboot.entity.UserVO;
import com.springboot.exception.UserNotFoundException;
import com.springboot.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	
	public UserVO saveUser(UserVO user) {
		return userRepo.save(user);
	}


	public List<UserVO> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}


	public UserVO findUserById(int id) throws Exception {
		// TODO Auto-generated method stub
		return userRepo.findById(id).orElseThrow(() -> new UserNotFoundException("user not found"));
	}


	public List<UserVO> getEmployeeByRole(String role) {
		return userRepo.findByRole(role);
	}
	
	public List<UserVO> getAgeUsingJPQL(int age){
		return userRepo.findAgeUsingJPQL(age);
	}
	
	public List<UserVO> findAgeUsingSQL(int age){
		return userRepo.findAgeUsingSQL(age);
	}
	
	public List<UserVO> findAgeUsingMethodSyntax(int age){
		System.out.println(userRepo.age().get());
		return userRepo.findByAgeGreaterThan(age);
	}
	
	public List<UserVO> listEmployeeBySortig(String field){
		return userRepo.findAll(Sort.by(Direction.DESC,field));
	}
	
	public Page<UserVO> listEmployeeWithPagination(int pageNumber,int pageSize,String field){
		return userRepo.findAll(PageRequest.of(pageNumber, pageSize).withSort(Direction.DESC,field));
	}


	public boolean deleteUser(int userId) {
		 userRepo.deleteById(userId);
		 return userRepo.existsById(userId);
		
	}
	
	public boolean updateUser(int userId) {
		 userRepo.deleteById(userId);
		 return userRepo.existsById(userId);
		
	}
}
