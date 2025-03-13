package com.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import com.security.config.UserInfoUserDetails;
import com.security.model.UserInfo;
import com.security.repository.UserInfoRepository;

@Component
@Scope(value = scope)
public class userInfoUserDetailService implements UserDetailsService {
	
	@Autowired
	UserInfoRepository userInfoRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
	Optional<UserInfo>	userInfo =  userInfoRepo.findByName(username);
	       return userInfo.map(UserInfoUserDetails::new)
	    		   .orElseThrow(()-> new UsernameNotFoundException("User not found"));
	}

}
