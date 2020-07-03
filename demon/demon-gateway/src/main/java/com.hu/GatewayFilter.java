package com.hu;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @author : hudelin
 * @className :GatewayFilter
 * @description : 自定义网关过滤器
 * @date: 2020-07-02 17:03
 */
@Configuration
public class GatewayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

//        //每次进来后判断带不带username这个key
//        String username = exchange.getRequest().getQueryParams().getFirst("username");
//        if(username == null){
//            //username为null非法用户
//            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
//            return exchange.getResponse().setComplete();
//        }
        return chain.filter(exchange);
    }
    @Override
    public int getOrder() {
        return 0;
    }
}