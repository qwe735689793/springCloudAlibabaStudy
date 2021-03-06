package com.mhj.demo.controller;

import com.mhj.demo.config.JmsConfig;
import com.mhj.demo.config.rocketMQ.Producer;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.client.producer.SendResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author MHJ
 * @version 1.0
 * @description
 * @createDate 2020/12/4 14:24
 **/
@Slf4j
@RestController
public class rocketMQTest {
    @Autowired
    private Producer producer;

    private List<String> mesList;

    /**
     * 初始化消息
     */
    public rocketMQTest() {
        mesList = new ArrayList<>();
        mesList.add("小小");
        mesList.add("爸爸");
        mesList.add("妈妈");
        mesList.add("爷爷");
        mesList.add("奶奶");

    }

    @RequestMapping("/text/rocketmq")
    public Object callback() throws Exception {
        //总共发送五次消息
        for (String s : mesList) {
            //创建生产信息
            Message message = new Message(JmsConfig.TOPIC, "testtag", ("小小一家人的称谓:" + s).getBytes());
            //发送
            SendResult sendResult = producer.getProducer().send(message);
            log.info("输出生产者信息={}",sendResult);
        }
        return "成功";
    }
}
