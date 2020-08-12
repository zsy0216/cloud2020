package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/12
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain9001 {
	public static void main(String[] args) {
		SpringApplication.run(PaymentMain9001.class, args);
	}
}
