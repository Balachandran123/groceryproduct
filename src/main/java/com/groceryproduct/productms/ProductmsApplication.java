package com.groceryproduct.productms;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/*
 * @author vijayalakshmi
 */

@SpringBootApplication
@EnableDiscoveryClient
public class ProductmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductmsApplication.class, args);
	}
	
	
}

