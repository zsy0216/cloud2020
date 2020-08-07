package org.example.service;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/06
 */
public interface PaymentService {

	/**
	 * 正常访问，OK成功
	 *
	 * @param id
	 * @return
	 */
	String paymentInfo_OK(Integer id);

	/**
	 * 超时访问 演示降级
	 *
	 * @param id
	 * @return
	 */
	String paymentInfo_TimeOut(Integer id);

	/**
	 * 服务熔断
	 *
	 * @param id
	 * @return
	 */
	String paymentCircuitBreaker(Integer id);
}
