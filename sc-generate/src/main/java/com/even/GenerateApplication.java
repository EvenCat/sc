package com.even;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 北方、
 * @title: GenerateApplication
 * @projectName sc
 * @description: TODO
 * @date 2020/8/1 19:20
 */
@SpringBootApplication
@MapperScan("com.even.mapper")
public class GenerateApplication {

    public static void main(String[] args) {
        SpringApplication.run(GenerateApplication.class);
    }
}
