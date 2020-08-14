package org.example.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/01
 */
@Configuration
public class ApplicationContextConfig {

	@LoadBalanced  //注意：注释掉这个注解后，之前通过服务名称远程调用会失效，不注释则无法通过URI进行调用(自写的轮询负载均衡算法)
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
