package com.even;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 北方、
 * @title: CASApplication
 * @projectName sc
 * @description: TODO
 * @date 2020/8/1 16:49
 */
@SpringBootApplication
@MapperScan("com.even.mapper")
//@EnableDiscoveryClient
//@EnableFeignClients
public class CASApplication {
    public static void main(String[] args) {
        SpringApplication.run(CASApplication.class);
    }
}
