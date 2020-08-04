package org.example;

import org.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/01
 */
@EnableEurekaClient
@SpringBootApplication
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class)
public class OrderMain80 {
	public static void main(String[] args) {
		SpringApplication.run(OrderMain80.class, args);
	}
}
