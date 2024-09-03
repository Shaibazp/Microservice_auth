package com.question.config;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.question.entity.UserInfo;
import com.question.repository.userInfoRepository;

@Component
public class customeUserDetailsService implements UserDetailsService {

	@Autowired
	private userInfoRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		Optional<UserInfo> users = repo.findByNm(username);
		
		return users.map(customeUserdetails::new).orElseThrow(()-> new UsernameNotFoundException("Not Found"));
	}

}
