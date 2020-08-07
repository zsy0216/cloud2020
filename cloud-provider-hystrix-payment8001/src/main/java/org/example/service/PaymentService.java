package org.example.service;

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
}
