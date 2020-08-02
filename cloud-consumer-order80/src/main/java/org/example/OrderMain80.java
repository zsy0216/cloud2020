package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/01
 */
@EnableEurekaClient
@SpringBootApplication
public class OrderMain80 {
	public static void main(String[] args) {
		SpringApplication.run(OrderMain80.class, args);
	}
}
