package org.example.service.impl;

import org.example.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/06
 */
@Service
public class PaymentServiceImpl implements PaymentService {

	@Override
	public String paymentInfo_OK(Integer id) {
		return "线程池：" + Thread.currentThread().getName() + " paymentInfo_OK, id：" + id + ",\t" + "拉拉拉";
	}

	@Override
	public String paymentInfo_TimeOut(Integer id) {
		long timeNumber = 3;
		try {
			TimeUnit.SECONDS.sleep(timeNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "线程池：" + Thread.currentThread().getName() + " paymentInfo_TimeOut, id: " + id + ",\t" + "阿巴阿巴," + " 耗时(秒): " + timeNumber;
	}
}
