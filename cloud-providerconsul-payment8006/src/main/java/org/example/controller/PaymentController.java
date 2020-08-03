package org.example.controller;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class PaymentController {

	@Value("${server.port}")
	private String serverPort;

	@GetMapping(value = "/payment/consul")
	public String paymentConsul() {
		return "spring-cloud with consul: " + serverPort + "\t" + UUID.randomUUID().toString();
	}
}