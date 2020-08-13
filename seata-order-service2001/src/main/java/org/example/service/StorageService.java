package org.example.service;

import org.example.domain.CommonResult;
import org.example.domain.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/13
 */
@FeignClient(value = "seata-storage-service")
public interface StorageService {
	/**
	 * decrease method 减库存
	 *
	 * @param productId productId
	 * @param count     count
	 * @return CommonResult<Order>
	 */
	@PostMapping(value = "/storage/decrease")
	CommonResult<Order> decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}

