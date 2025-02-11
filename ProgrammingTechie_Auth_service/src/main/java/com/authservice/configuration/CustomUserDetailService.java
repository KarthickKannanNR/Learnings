package com.authservice.configuration;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.authservice.entity.UserInfo;
import com.authservice.repository.UserCredantialRepository;

@Service
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	UserCredantialRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<UserInfo> user  = userRepo.findByName(userName);
		return user.map(CustomUserDetails::new).orElseThrow(()->new UsernameNotFoundException("This username "+userName+"is not exists"));
	}

}
