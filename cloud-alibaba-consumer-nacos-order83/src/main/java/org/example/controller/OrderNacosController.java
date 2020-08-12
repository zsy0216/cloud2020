package org.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/12
 */

@RestController
public class OrderNacosController {
	@Resource
	private RestTemplate restTemplate;

	@Value("${service-url.name}")
	private String serverURL;

	@GetMapping(value = "/consumer/payment/nacos/{id}")
	public String paymentInfo(@PathVariable("id") Long id) {
		return restTemplate.getForObject(serverURL + "/payment/nacos/" + id, String.class);
	}
}
