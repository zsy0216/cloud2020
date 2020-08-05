package org.example.service;

import org.example.common.CommonResult;
import org.example.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/05
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

	@GetMapping(value = "/payment/get/{id}")
	CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);
}

