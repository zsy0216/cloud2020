package org.example.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/04
 */
public interface LoadBalancer {
	/**
	 * 收集服务器总共有多少台能够提供服务的机器，并放到list里面
	 */
	ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
