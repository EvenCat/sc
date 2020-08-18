package com.even.producer;

import com.even.config.JmsConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author 北方、
 * @title: Producer
 * @projectName sc
 * @description: TODO
 * @date 2020/8/10 14:17
 */
//@Component
@Slf4j
@Configuration
public class Producer {
    private String producerGroup = "test_producer";

    @Bean
    public DefaultMQProducer defaultMQProducer() throws MQClientException{
        DefaultMQProducer defaultMQProducer = new DefaultMQProducer(producerGroup);
        defaultMQProducer.setVipChannelEnabled(false);
        defaultMQProducer.setNamesrvAddr(JmsConfig.NAME_SERVER);
        defaultMQProducer.start();
        log.info("生产者启动成功--------------------");
        return defaultMQProducer;

    }


}
