package org.example.service;

import org.springframework.stereotype.Component;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/07
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
	@Override
	public String paymentInfo_OK(Integer id) {
		return "-----PaymentFallbackService fall back-paymentInfo_OK , (┬＿┬)";
	}

	@Override
	public String paymentInfo_TimeOut(Integer id) {
		return "-----PaymentFallbackService fall back-paymentInfo_TimeOut , (┬＿┬)";
	}
}
