package com.even.config;

import com.even.filter.LoginGatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.stereotype.Component;

/**
 * @author 北方、
 * @title: AuthGatewayFilterFactory
 * @projectName sc
 * @description: TODO
 * @date 2020/8/2 14:24
 */
@Component
public class LoginGatewayFilterFactory extends AbstractGatewayFilterFactory<Object> {
    @Override
    public GatewayFilter apply(Object config) {
        return new LoginGatewayFilter();
    }
}
