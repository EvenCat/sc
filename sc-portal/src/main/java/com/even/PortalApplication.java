package com.even;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 北方、
 * @title: com.even.Application
 * @projectName sc
 * @description: TODO
 * @date 2020/8/1 15:22
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PortalApplication {
    public static void main(String[] args) {
        SpringApplication.run(PortalApplication.class, args);
    }
}
