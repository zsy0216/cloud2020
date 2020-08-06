package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.common.CommonResult;
import org.example.entity.Payment;
import org.example.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/01
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

	@Resource
	PaymentService paymentService;

	@Value("${server.port}")
	String serverPort;

	@Resource
	DiscoveryClient discoveryClient;

	@PostMapping("/create")
	public CommonResult<Integer> create(@RequestBody Payment payment) {
		int result = paymentService.create(payment);
		log.info("插入结果: {}", result);
		if (result > 0) {
			return new CommonResult(200, "插入数据库成功, 服务端口: " + serverPort, result);
		} else {
			return new CommonResult(444, "插入数据库失败");
		}
	}

	@GetMapping("/get/{id}")
	public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
		Payment payment = paymentService.getPaymentById(id);
		log.info("查询结果: {}", payment);
		if (payment != null) {
			return new CommonResult(200, "查询数据成功, 服务端口: " + serverPort, payment);
		} else {
			return new CommonResult(444, "没有对应记录, 查询 id: " + id);
		}
	}

	@GetMapping("/discovery")
	public Object discovery() {
		List<String> services = discoveryClient.getServices();
		for (String service : services) {
			log.info("service: {}", service);
		}

		List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
		for (ServiceInstance instance : instances) {
			log.info(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
		}

		return this.discoveryClient;
	}

	@GetMapping(value = "/lb")
	public String getPaymentLB() {
		return serverPort;
	}

	@GetMapping(value = "/feign/timeout")
	public String paymentFeignTimeout() {
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return serverPort;
	}
}
