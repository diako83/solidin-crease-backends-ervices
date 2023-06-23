package com.soldincrease.YogaServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication

@EnableDiscoveryClient
public class YogaServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(YogaServicesApplication.class, args);
	}

}
