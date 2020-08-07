package org.example.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.example.service.PaymentHystrixService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/07
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")
public class OrderHystrixController {

	@Resource
	private PaymentHystrixService paymentHystrixService;

	@Value("${server.port}")
	private String serverPort;

	@GetMapping("/consumer/payment/hystrix/ok/{id}")
	public String paymentInfo_OK(@PathVariable("id") Integer id) {
		String result = paymentHystrixService.paymentInfo_OK(id);
		log.info("result: {}, serverPort: {}", result, serverPort);
		return result;
	}

	//@HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
	//		@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
	//		//3秒钟以内就是正常的业务逻辑
	//})
	@HystrixCommand
	@GetMapping("/consumer/payment/hystrix/timeout/{id}")
	public String paymentInfoTimeOut(@PathVariable("id") Integer id) {
		int a = 10 / 0;
		String result = paymentHystrixService.paymentInfo_TimeOut(id);
		log.info("result: {}, serverPort: {}", result, serverPort);
		return result;
	}

	public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id) {
		return "我是消费者80，8001系统繁忙请10秒钟后再试或者自己运行出错请检查自己, o(╥﹏╥)o";
	}

	/**
	 * Global Fallback method.
	 */
	public String paymentGlobalFallbackMethod() {
		return "Global异常处理信息，请稍后再试,(┬＿┬)";
	}
}
