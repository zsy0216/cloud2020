package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/10
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayMain9527 {
	public static void main(String[] args) {
		SpringApplication.run(GatewayMain9527.class, args);
	}
}


