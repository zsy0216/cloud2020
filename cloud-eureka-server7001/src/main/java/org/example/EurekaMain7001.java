package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/02
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaMain7001 {
	public static void main(String[] args) {
		SpringApplication.run(EurekaMain7001.class, args);
	}
}
