package org.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/10
 */
@RestController
public class ConfigClientController {

	@Value("${config.info}")
	private String configInfo;

	@GetMapping("/config-info")
	public String getConfigInfo() {
		return configInfo;
	}
}
