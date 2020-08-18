package com.even.controller;

import com.even.api.UserService;
import com.even.common.ResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author 北方、
 * @title: IndexController
 * @projectName sc
 * @description: TODO
 * @date 2020/8/10 14:21
 */
@RestController
@Slf4j
public class IndexController {


    /* @Autowired
     private DefaultMQProducer producer;

     @RequestMapping("/send")
     public ResponseModel sentMessage(String msg) throws Exception {
         Message message = new Message(JmsConfig.TOPIC,"testtag",msg.getBytes());
         SendResult send = producer.send(message);
         log.info("生产者消息={}",send);
         return ResponseModel.OK("发送成功", send);
     }*/
    @Autowired
    UserService userService;

    @RequestMapping("/login")
    public ResponseModel login(@RequestParam Map<String, String> data) {
        data.put("grant_type","password");
        data.put("client_id","client-app");
        data.put("client_secret","123456");
        data.put("scope","all");
        ResponseModel token = userService.getToken(data);
        return token;
    }
}
