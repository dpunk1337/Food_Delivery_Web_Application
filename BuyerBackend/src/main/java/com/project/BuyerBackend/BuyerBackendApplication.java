package com.project.BuyerBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.project.BuyerBackend.configuration.RibbonConfiguration;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "my-server",configuration = RibbonConfiguration.class)
public class BuyerBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BuyerBackendApplication.class, args);
	}

}
