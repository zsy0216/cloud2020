package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author shuaiyin.zhang
 * @description @EnableDiscoveryClient 注解用于向使用Consul和Zookeeper作为注册中心时注册服务
 * @date 2020/08/02
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8004 {
	public static void main(String[] args) {
		SpringApplication.run(PaymentMain8004.class, args);
	}
}
