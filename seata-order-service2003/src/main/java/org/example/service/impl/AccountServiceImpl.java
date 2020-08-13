package org.example.service.impl;

import org.example.dao.AccountDao;
import org.example.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/13
 */
@Service
public class AccountServiceImpl implements AccountService {

	private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

	@Resource
	AccountDao accountDao;

	/**
	 * 扣减账户余额
	 */
	@Override
	public void decrease(Long userId, BigDecimal money) {

		LOGGER.info("------->account-service中扣减账户余额开始");
		try {
			TimeUnit.SECONDS.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		accountDao.decrease(userId, money);
		LOGGER.info("------->account-service中扣减账户余额结束");
	}
}

