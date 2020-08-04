package org.example.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/04
 */
@Component
public class LoadBalancerImpl implements LoadBalancer {
	private AtomicInteger atomicInteger = new AtomicInteger(0);

	/**
	 * 获取访问次数
	 *
	 * @return
	 */
	final int getAndIncrement() {
		int current;
		int next;
		do {
			current = this.atomicInteger.get();
			next = current >= 2147483647 ? 0 : current + 1;
		} while (!this.atomicInteger.compareAndSet(current, next));  //第一个参数是期望值，第二个参数是修改值是
		System.out.println("*******第几次访问，次数 next: " + next);
		return next;
	}

	/**
	 * @param serviceInstances 得到服务的列表
	 * @return 服务实例
	 */
	@Override
	public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
		// 得到服务器的下标
		int index = getAndIncrement() % serviceInstances.size();
		return serviceInstances.get(index);
	}
}