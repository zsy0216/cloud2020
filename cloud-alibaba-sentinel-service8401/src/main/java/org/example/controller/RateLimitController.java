package org.example.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.example.common.CommonResult;
import org.example.entity.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/13
 */
@RestController
public class RateLimitController {
	@GetMapping("/byResource")
	@SentinelResource(value = "byResource", blockHandler = "handleException")
	public CommonResult byResource() {
		return new CommonResult(200, "按资源名称限流测试OK", new Payment(2020L, "serial001"));
	}

	public CommonResult handleException(BlockException exception) {
		return new CommonResult(444, exception.getClass().getCanonicalName() + ": 服务不可用");
	}
}
