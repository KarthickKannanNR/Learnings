package com.springbootsecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springbootsecurity.model.UserInfo;
import com.springbootsecurity.model.UserPrincipal;
import com.springbootsecurity.repository.UserRepo;

@Service
public class UserDetailService implements UserDetailsService{

	@Autowired
	UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserInfo user = userRepo.findByName(username);
		
		if(user == null) {
			throw new UsernameNotFoundException("The user ".concat(username).concat("is not exists in database"));
		}
		
		return new UserPrincipal(user);
	}

}
