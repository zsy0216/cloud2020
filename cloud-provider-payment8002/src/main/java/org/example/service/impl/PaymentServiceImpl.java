package org.example.service.impl;

import org.example.entity.Payment;
import org.example.mapper.PaymentMapper;
import org.example.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/01
 */
@Service
public class PaymentServiceImpl implements PaymentService {

	@Resource
	PaymentMapper paymentMapper;

	@Override
	public int create(Payment record) {
		return paymentMapper.create(record);
	}

	@Override
	public Payment getPaymentById(Long id) {
		return paymentMapper.getPaymentById(id);
	}
}
