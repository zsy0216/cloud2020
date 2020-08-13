package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
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
}

