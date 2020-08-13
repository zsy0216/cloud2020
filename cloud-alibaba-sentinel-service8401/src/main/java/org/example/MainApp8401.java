package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/13
 */
@EnableDiscoveryClient
@SpringBootApplication
public class MainApp8401 {
	public static void main(String[] args) {
		SpringApplication.run(MainApp8401.class, args);
	}
}
