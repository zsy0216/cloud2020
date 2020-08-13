package org.example.controller;

import org.example.domain.CommonResult;
import org.example.domain.Order;
import org.example.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/13
 */
@RestController
public class OrderController {
	@Resource
	private OrderService orderService;

	@GetMapping("/order/create")
	public CommonResult<Order> create(Order order) {
		orderService.create(order);
		return new CommonResult<>(200, "订单创建成功");
	}
}

