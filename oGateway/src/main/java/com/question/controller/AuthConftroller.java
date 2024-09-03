package com.question.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.question.entity.UserInfo;
import com.question.service.authService;

import jakarta.ws.rs.POST;

@RestController
@RequestMapping("/auths")
public class AuthConftroller 
{
	@Autowired
	private authService authService;
	
	@Autowired
	private AuthenticationManager manager;
	
	@GetMapping("/msg")
	public String mshget()
	{
		return "Connected.....";
	}
	
	@PostMapping("/register")
	public UserInfo addnewUSer(@RequestBody UserInfo info)
	{
		return authService.saveuser(info);
	}
	
	@GetMapping("/token")
	public String gettoken(@RequestBody UserInfo info)
	{
		Authentication auths = manager.authenticate(new UsernamePasswordAuthenticationToken(info.getNm(), info.getPass()));
		System.out.println(auths);
		if(auths.isAuthenticated())
		{
			return authService.generateTocken(info.getNm());
		}
		else
		{
			return "Invalid User";
		}
	}
	
	@GetMapping("/validate")
	public String validatetoken(@RequestParam("token") String token)
	{
		authService.ValidateTokens(token);
		return  "valid";
	}
	
}
