package com.question.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class wenSecurity 
{
	@Bean
	public UserDetailsService userservice()
	{
		return new customeUserDetailsService();
	}
	
	
	@Bean
	public SecurityFilterChain chain(HttpSecurity httpSecurity) throws Exception
	{
		return httpSecurity.csrf().disable()
				.authorizeHttpRequests()
				.requestMatchers("/auths/msg","/auths/register", "/auths/token", "/auths/validate").permitAll()
				.and()
				.build();
	}
	
	@Bean
	public AuthenticationProvider authprovider()
	{
			DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
			authenticationProvider.setUserDetailsService(userservice());
			authenticationProvider.setPasswordEncoder(passwordEncoder());
			return authenticationProvider;
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception
	{
		return configuration.getAuthenticationManager(); 
	}
	
	@Bean
	public PasswordEncoder  passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
}
