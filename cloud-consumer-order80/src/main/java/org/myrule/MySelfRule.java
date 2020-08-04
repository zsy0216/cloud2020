package org.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/04
 */
@Configuration
public class MySelfRule {

	/**
	 * 定义为随机
	 *
	 * @return
	 */
	@Bean
	public IRule myRule() {
		return new RandomRule();
	}
}
