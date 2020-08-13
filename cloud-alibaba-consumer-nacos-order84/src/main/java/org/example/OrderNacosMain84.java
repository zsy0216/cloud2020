package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/13
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class OrderNacosMain84 {
	public static void main(String[] args) {
		SpringApplication.run(OrderNacosMain84.class, args);
	}
}

