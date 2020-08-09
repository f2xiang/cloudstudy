package com.fengx.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by apple on 2020/8/9.
 * Gateway路由配置，代码的方式
 */
@Configuration
public class GatewayConfig {

//    @Bean
//    public RouteLocator setGatewayRouter(RouteLocatorBuilder routeLocatorBuilder) {
//        RouteLocatorBuilder.Builder builder = routeLocatorBuilder.routes();
//        builder.route("my_route_id",
//                r -> r.path("/baidu")
//                        .uri("http://www.baidu.com"));
//        return builder.build();
//    }

}
