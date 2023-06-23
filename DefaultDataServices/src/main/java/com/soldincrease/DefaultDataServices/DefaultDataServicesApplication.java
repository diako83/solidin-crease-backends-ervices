package com.soldincrease.DefaultDataServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class DefaultDataServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DefaultDataServicesApplication.class, args);
	}

}
