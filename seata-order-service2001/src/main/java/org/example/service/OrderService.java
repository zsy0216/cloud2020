package org.example.service;

import org.example.domain.Order;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/13
 */
public interface OrderService {
	/**
	 * create method 创建订单
	 *
	 * @param order order
	 */
	void create(Order order);
}