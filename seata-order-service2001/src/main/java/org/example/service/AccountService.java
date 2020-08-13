package org.example.service;

import org.example.domain.CommonResult;
import org.example.domain.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/13
 */

@FeignClient(value = "seata-account-service")
public interface AccountService {
	/**
	 * decrease method 建账户余额
	 *
	 * @param userId userId
	 * @param money  money
	 * @return CommonResult<Order>
	 */
	@PostMapping(value = "/account/decrease")
	CommonResult<Order> decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money);
}