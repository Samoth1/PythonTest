package com.tingeso.pythontestservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PythontestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PythontestServiceApplication.class, args);
	}

}
