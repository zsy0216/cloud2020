package org.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/11
 */
@RestController
@RefreshScope
public class ConfigClientController {

	@Value("${server.port}")
	private String serverPort;

	@Value("${config.info}")
	private String configInfo;

	@GetMapping("/configInfo")
	public String getConfigInfo() {
		return "serverPort: " + serverPort + "\t\n\n configInfo: " + configInfo;
	}
}