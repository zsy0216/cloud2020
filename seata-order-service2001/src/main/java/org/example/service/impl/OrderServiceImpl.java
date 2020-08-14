package org.example.service.impl;

import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.example.dao.OrderDao;
import org.example.domain.Order;
import org.example.service.AccountService;
import org.example.service.OrderService;
import org.example.service.StorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/13
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
	@Resource
	private OrderDao orderDao;
	@Resource
	private StorageService storageService;
	@Resource
	private AccountService accountService;

	/**
	 * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
	 */
	//@GlobalTransactional(name = "fsp-create-order", rollbackFor = Exception.class)
	@Override
	public void create(Order order) {
		log.info("----->开始新建订单");
		//新建订单
		orderDao.create(order);

		//扣减库存
		log.info("----->订单微服务开始调用库存，做扣减Count");
		storageService.decrease(order.getProductId(), order.getCount());
		log.info("----->订单微服务开始调用库存，做扣减end");

		//扣减账户
		log.info("----->订单微服务开始调用账户，做扣减Money");
		accountService.decrease(order.getUserId(), order.getMoney());
		log.info("----->订单微服务开始调用账户，做扣减end");


		//修改订单状态，从零到1代表已经完成
		log.info("----->修改订单状态开始");
		orderDao.update(order.getUserId(), 0);
		log.info("----->修改订单状态结束");

		log.info("----->下订单结束了");
	}
}

