package org.example.service;

import org.example.common.CommonResult;
import org.example.entity.Payment;
import org.springframework.stereotype.Component;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/13
 */
@Component
public class PaymentFallbackService implements PaymentService {
	@Override
	public CommonResult<Payment> paymentSql(Long id) {
		return new CommonResult<>(44444, "服务降级返回, PaymentFallbackService", new Payment(id, "errorSerial"));
	}
}
