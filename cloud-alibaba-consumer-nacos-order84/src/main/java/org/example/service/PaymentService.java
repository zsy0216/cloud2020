package org.example.service;

import org.example.common.CommonResult;
import org.example.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/13
 */
@FeignClient(value = "nacos-payment-provider", fallback = PaymentFallbackService.class)
public interface PaymentService {
	/**
	 * 通过 feign 调用 9003/9004 接口
	 *
	 * @param id id
	 * @return CommonResult
	 */
	@GetMapping(value = "/paymentSQL/{id}")
	CommonResult<Payment> paymentSql(@PathVariable("id") Long id);
}