package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.service.PaymentHystrixService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/07
 */
@RestController
@Slf4j
public class OrderHystrixController {

	@Resource
	private PaymentHystrixService paymentHystrixService;

	@Value("${server.port}")
	private String serverPort;

	@GetMapping("/consumer/payment/hystrix/ok/{id}")
	public String paymentInfo_OK(@PathVariable("id") Integer id) {
		String result = paymentHystrixService.paymentInfo_OK(id);
		log.info("result: {}, serverPort: {}", result, serverPort);
		return result;
	}

	@GetMapping("/consumer/payment/hystrix/timeout/{id}")
	public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
		String result = paymentHystrixService.paymentInfo_TimeOut(id);
		log.info("result: {}, serverPort: {}", result, serverPort);
		return result;
	}

}
