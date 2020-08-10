package org.example.filter;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/10
 */
@Component
@Slf4j
public class MyLogGatewayFilter implements GlobalFilter, Ordered {
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		log.info("****come in MyLogGatewayFilter: {}", new Date());
		String username = exchange.getRequest().getQueryParams().getFirst("username");
		if (StringUtils.isEmpty(username)) {
			log.info("****用户名为Null 非法用户, (┬＿┬)");
			// 设置响应
			exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
			return exchange.getResponse().setComplete();
		}
		return chain.filter(exchange);
	}

	@Override
	public int getOrder() {
		return 0;
	}
}

