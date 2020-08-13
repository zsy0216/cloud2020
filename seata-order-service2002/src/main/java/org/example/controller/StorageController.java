package org.example.controller;

import org.example.domain.CommonResult;
import org.example.domain.Storage;
import org.example.service.StorageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/13
 */
@RestController
public class StorageController {

	@Resource
	private StorageService storageService;

	/**
	 * 扣减库存
	 *
	 * @param productId productId
	 * @param count     count
	 * @return CommonResult<Storage>
	 */
	@RequestMapping("/storage/decrease")
	public CommonResult<Storage> decrease(Long productId, Integer count) {
		storageService.decrease(productId, count);
		return new CommonResult<>(200, "扣减库存成功！");
	}
}

