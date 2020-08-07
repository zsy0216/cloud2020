package org.example.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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

	@HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
			// 3秒钟以内就是正常的业务逻辑
	})
	@Override
	public String paymentInfo_TimeOut(Integer id) {
		//int a = 10 / 0;
		long timeNumber = 3;
		try {
			TimeUnit.SECONDS.sleep(timeNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "线程池：" + Thread.currentThread().getName() + " paymentInfo_TimeOut, id: " + id + ",\t" + "阿巴阿巴," + " 耗时(秒): " + timeNumber;
	}

	/**
	 * 超时访问 演示降级
	 *
	 * @param id
	 * @return
	 */
	public String paymentInfo_TimeOutHandler(Integer id) {
		return "线程池: " + Thread.currentThread().getName() + " 系统繁忙, 请稍候再试,id: " + id + ",\t" + "o(╥﹏╥)o";
	}
}
