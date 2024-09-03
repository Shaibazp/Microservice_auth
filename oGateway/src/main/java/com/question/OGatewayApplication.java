package com.question;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class OGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(OGatewayApplication.class, args);
	}

}
