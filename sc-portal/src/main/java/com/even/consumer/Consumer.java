package com.even.consumer;

import com.even.config.JmsConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

/**
 * @author 北方、
 * @title: Consumer
 * @projectName sc
 * @description: TODO
 * @date 2020/8/10 14:22
 */
@Slf4j
@Component
public class Consumer {

    private DefaultMQPushConsumer consumer;

    public static final String CONSUMER_GROUP = "test_consumer";

    public Consumer() throws MQClientException {
        consumer = new DefaultMQPushConsumer(CONSUMER_GROUP);
        consumer.setNamesrvAddr(JmsConfig.NAME_SERVER);
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
        consumer.subscribe(JmsConfig.TOPIC,"*");
        consumer.registerMessageListener((MessageListenerConcurrently)(msgs, context) -> {
            try {
                for (MessageExt msg : msgs) {
                    String body = new String(msg.getBody(),"UTF-8");
                    log.info("Consumer-获取消息-主体topic为={}, 消费消息为={}",msg.getTopic(),body);
                }
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });
        consumer.start();
        log.info("Consumer启动成功-------------------------------");
    }
}
