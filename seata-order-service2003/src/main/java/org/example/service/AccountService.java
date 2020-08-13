package org.example.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/13
 */
public interface AccountService {

	/**
	 * 扣减账户余额
	 *
	 * @param userId userId
	 * @param money  money
	 */
	void decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}
