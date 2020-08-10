package org.example.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shuaiyin.zhang
 * @description
 * @date 2020/08/10
 */
@Configuration
public class GatewayConfig {

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
		RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
		routes.route("path_rote_tassel",
				r -> r.path("/guonei")
				.uri("http://news.baidu.com/guonei"))
				.build();
		routes.route("path_rote_tassel2",
				r -> r.path("/guoji")
				.uri("http://news.baidu.com/guoji"))
				.build();
		/*routes.route("path_rote_tassel3",
				r -> r.path("/**")
				.uri("http://news.baidu.com/**"))
				.build();*/
		return routes.build();
	}

}
