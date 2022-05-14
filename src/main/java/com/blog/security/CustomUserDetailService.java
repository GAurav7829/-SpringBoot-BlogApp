package com.blog.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.blog.entities.User;
import com.blog.repositories.UserRepository;
import com.blog.utils.CommonMethodsUtils;

@Service
public class CustomUserDetailService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//loading user from db by username
		User user = this.userRepository.findByEmail(username).orElseThrow(CommonMethodsUtils.resourceNotFound("User", "Email", username));
		return user;
	}

}
