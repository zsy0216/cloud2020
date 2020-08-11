package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/11
 */
@EnableEurekaClient
@SpringBootApplication
public class ConfigClientMain3366 {
	public static void main(String[] args) {
		SpringApplication.run(ConfigClientMain3366.class, args);
	}
}

