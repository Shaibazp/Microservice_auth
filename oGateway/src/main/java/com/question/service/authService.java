package com.question.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.netflix.discovery.converters.Auto;
import com.question.config.jwtConfig;
import com.question.entity.UserInfo;
import com.question.repository.userInfoRepository;

@Service
public class authService 
{
	@Autowired
	private userInfoRepository infoRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private jwtConfig configs;
	
	
	@Autowired
	private AuthenticationManager manager;
	
	
	
	public String generateTocken(String uname)
	{
		return configs.generateToken(uname);
	}
	
	public void ValidateTokens(String token)
	{
		configs.validateToken(token);
	}
	public UserInfo saveuser(UserInfo info)
	{
		info.setPass(encoder.encode(info.getPass()));
		return infoRepository.save(info);
	}
}
