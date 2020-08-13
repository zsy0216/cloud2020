package org.example.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/13
 */
@Configuration
@MapperScan({"org.example.dao"})
public class MyBatisConfig {
}
