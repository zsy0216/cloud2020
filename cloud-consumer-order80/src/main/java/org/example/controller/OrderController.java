package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.common.CommonResult;
import org.example.entity.Payment;
import org.example.lb.LoadBalancer;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/01
 */
@RequestMapping("/consumer")
@RestController
@Slf4j
public class OrderController {
	//private static final String PAYMENT_URL = "http://localhost:8001";
	private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

	@Resource
	private RestTemplate restTemplate;

	@Resource
	private LoadBalancer loadBalancer;

	@Resource
	private DiscoveryClient discoveryClient;

	@GetMapping("/payment/create")
	public CommonResult<Payment> create(Payment payment) {
		return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
	}

	@GetMapping("/payment/get/{id}")
	public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
		return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
	}

	/**
	 * RestTemplate 方法介绍
	 * <p>
	 * 1. getForObject(): 返回对象为响应体中数据转化的对象，基本上可以理解为json
	 * 2. getForEntity(): 返回对象为 ResponseEntity 对象，包含了相应中的一些重要信息，比如响应头、响应状态码、响应体等
	 * 3. postForObject():
	 * 4. postForEntity():
	 */

	@GetMapping("/payment/getForEntity/{id}")
	public CommonResult<Payment> getPaymentForEntity(@PathVariable("id") Long id) {
		ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
		if (entity.getStatusCode().is2xxSuccessful()) {
			log.info(entity.getStatusCode() + "\t" + entity.getHeaders());
			return entity.getBody();
		} else {
			return new CommonResult<>(444, "请求失败");
		}
	}

	@GetMapping("/payment/createForEntity")
	public CommonResult createForEntity(Payment payment) {
		return restTemplate.postForEntity(PAYMENT_URL + "/payment/create", payment, CommonResult.class).getBody();
	}

	@GetMapping(value = "/payment/lb")
	public String getPaymentLB() {
		List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
		if (instances == null || instances.isEmpty()) {
			return null;
		}
		ServiceInstance serviceInstance = loadBalancer.instances(instances);
		URI uri = serviceInstance.getUri();
		return restTemplate.getForObject(uri + "/payment/lb", String.class);
	}

	/**
	 * zipkin+sleuth
	 */
	@GetMapping("/payment/zipkin")
	public String paymentZipkin() {
		return restTemplate.getForObject("http://localhost:8001" + "/payment/zipkin/", String.class);
	}
}
