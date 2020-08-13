package org.example.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/13
 */
@RestController
@Slf4j
public class FlowLimitController {
	@GetMapping("/testA")
	public String testA() {
		return "------testA";
	}

	@GetMapping("/testB")
	public String testB() {
		return "------testB";
	}

	@GetMapping("/testD")
	public String testD() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info("testD 测试RT");
		return "------testD";
	}

	@GetMapping("/testHotKey")
	@SentinelResource(value = "testHotKey", blockHandler = "deal_testHotKey")
	public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
							 @RequestParam(value = "p2", required = false) String p2) {
		//int age = 10/0;
		return "------testHotKey";
	}

	/**
	 * 兜底方法
	 */
	public String deal_testHotKey(String p1, String p2, BlockException exception) {
		return "------deal_testHotKey,o(╥﹏╥)o";
	}
}

