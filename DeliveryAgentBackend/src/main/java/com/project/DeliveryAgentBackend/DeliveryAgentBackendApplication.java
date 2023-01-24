package com.project.DeliveryAgentBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.project.DeliveryAgentBackend.configuration.RibbonConfiguration;

@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "my-server",configuration = RibbonConfiguration.class)
public class DeliveryAgentBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeliveryAgentBackendApplication.class, args);
	}

}
