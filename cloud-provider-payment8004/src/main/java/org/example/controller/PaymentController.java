package org.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/03
 */
@RestController
public class PaymentController {
	@Value("${server.port}")
	private String serverPort;

	@GetMapping(value = "/payment/zk")
	public String paymentzk() {
		return "springcloud with zookeeper: " + serverPort + "\t" + UUID.randomUUID().toString();
	}
}
