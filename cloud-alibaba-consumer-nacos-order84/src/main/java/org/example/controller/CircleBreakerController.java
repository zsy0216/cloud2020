package org.example.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.example.common.CommonResult;
import org.example.entity.Payment;
import org.example.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/13
 */
@RestController
@Slf4j
public class CircleBreakerController {

	public static final String SERVICE_URL = "http://nacos-payment-provider";

	@Resource
	private RestTemplate restTemplate;

	@RequestMapping("/consumer/fallback/{id}")
	@SentinelResource(value = "fallback",
			fallback = "handlerFallback",   // fallback 只负责业务异常
			blockHandler = "blockHandler",  // blockHandler 只负责 sentinel 控制台配置违规
			exceptionsToIgnore = {IllegalArgumentException.class})  // 忽略业务异常，人工处理
	public CommonResult<Payment> fallback(@PathVariable Long id) {
		CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class, id);
		if (id == 4) {
			throw new IllegalArgumentException("IllegalArgumentException, 非法参数异常....");
		} else if (result.getData() == null) {
			throw new NullPointerException("NullPointerException, 该ID没有对应记录, 空指针异常");
		}
		return result;
	}

	/**
	 * fallback
	 */
	public CommonResult<Payment> handlerFallback(@PathVariable Long id, Throwable e) {
		Payment payment = new Payment(id, "null");
		return new CommonResult<>(444, "兜底异常handlerFallback, exception内容 " + e.getMessage(), payment);
	}

	/**
	 * blockHandler
	 */
	public CommonResult<Payment> blockHandler(@PathVariable Long id, BlockException blockException) {
		Payment payment = new Payment(id, "null");
		return new CommonResult<>(445, "blockHandler-sentinel限流, 无此流水: blockException " + blockException.getMessage(), payment);
	}

	/**
	 * ***********OpenFeign************
	 */
	@Resource
	private PaymentService paymentService;

	/**
	 * 通过OpenFeign调用
	 */
	@GetMapping(value = "/consumer/paymentSQL/{id}")
	public CommonResult<Payment> paymentSql(@PathVariable("id") Long id) {
		return paymentService.paymentSql(id);
	}
}