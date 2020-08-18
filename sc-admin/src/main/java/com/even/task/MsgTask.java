package com.even.task;

import com.even.config.JmsConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 北方、
 * @title: MsgTask
 * @projectName sc
 * @description: TODO
 * @date 2020/8/10 15:15
 */
@Component
@Slf4j
public class MsgTask {

    @Autowired
    private DefaultMQProducer producer;
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

//    @Scheduled(cron = "0/1 * *  * * ?")
    private void sendMsg() throws Exception{
        for (int i = 0; i < 20; i++) {
            Message message = new Message(JmsConfig.TOPIC, "testtag", sdf.format(new Date()).getBytes());
            producer.send(message);
        }
        log.info("生产者消息成功");
    }
}
