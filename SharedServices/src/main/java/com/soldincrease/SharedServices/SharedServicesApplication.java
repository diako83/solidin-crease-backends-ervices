package com.soldincrease.SharedServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SharedServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SharedServicesApplication.class, args);
	}

}
