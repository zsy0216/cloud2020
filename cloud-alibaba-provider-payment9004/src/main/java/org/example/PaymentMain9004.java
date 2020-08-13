package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/13
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain9004 {
	public static void main(String[] args) {
		SpringApplication.run(PaymentMain9004.class, args);
	}
}

