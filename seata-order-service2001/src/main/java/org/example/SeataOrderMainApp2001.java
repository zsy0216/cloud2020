package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author shuaiyin.zhang
 * @description exclude: 取消数据源自动创建的配置 使用seata 数据源进行代理
 * @date 2020/08/13
 */
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SeataOrderMainApp2001 {
	public static void main(String[] args) {
		SpringApplication.run(SeataOrderMainApp2001.class, args);
	}
}
