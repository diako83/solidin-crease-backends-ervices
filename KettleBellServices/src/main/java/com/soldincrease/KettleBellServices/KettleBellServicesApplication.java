package com.soldincrease.KettleBellServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication

@EnableDiscoveryClient
public class KettleBellServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(KettleBellServicesApplication.class, args);
	}

}
