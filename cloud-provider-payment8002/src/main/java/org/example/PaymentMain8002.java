package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author shuaiyin.zhang
 * @description payment8002 主启动类
 * @date 2020/08/01
 */
@EnableEurekaClient
@SpringBootApplication
public class PaymentMain8002 {
	public static void main(String[] args) {
		SpringApplication.run(PaymentMain8002.class, args);
	}
}
