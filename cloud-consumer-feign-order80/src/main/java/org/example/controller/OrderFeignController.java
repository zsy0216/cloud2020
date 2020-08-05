package org.example.controller;

import org.example.common.CommonResult;
import org.example.entity.Payment;
import org.example.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/05
 */
@RestController
public class OrderFeignController {

	@Resource
	private PaymentFeignService paymentFeignService;

	@GetMapping(value = "/consumer/payment/get/{id}")
	public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
		return paymentFeignService.getPaymentById(id);
	}

	@GetMapping(value = "/consumer/payment/feign/timeout")
	public String paymentFeignTimeout() {
		// openFeign-Ribbon 客户端一般默认等待1秒钟
		return paymentFeignService.paymentFeignTimeout();
	}
}
