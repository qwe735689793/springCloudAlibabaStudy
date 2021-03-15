package com.mhj.demo.base1.consumer;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

/**
 * @author MHJ
 * @version 1.0
 * @description
 * @createDate 2020/12/19 19:55
 **/
public class consumer {
    public static void main(String[] args) throws Exception {
//        1.创建消费者Consumer，制定消费者组名  （里面的）
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("group1");
//        2.指定Nameserver地址
        consumer.setNamesrvAddr("47.98.250.133:9876");
//        3.订阅主题Topic和Tag
        consumer.subscribe("group1","*");
        /*
        * CLUSTERING 负载均衡
        * BROADCASTING  广播  布拉卡行
        * */
        consumer.setMessageModel(MessageModel.BROADCASTING);
//        4.设置回调函数，处理消息
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for (MessageExt msg: list){
                    System.out.println(new String(msg.getBody()));
                }
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
//        5.启动消费者consumer
        consumer.start();

    }
}
