package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/05
 */
@SpringBootApplication
@EnableFeignClients
public class OrderFeignMain80 {
	public static void main(String[] args) {
		SpringApplication.run(OrderFeignMain80.class, args);
	}
}
