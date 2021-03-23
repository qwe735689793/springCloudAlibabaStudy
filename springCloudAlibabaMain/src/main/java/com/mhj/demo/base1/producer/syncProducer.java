package com.mhj.demo.base1.producer;

import com.mhj.demo.config.JmsConfig;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;

/**
 * @author MHJ
 * @version 1.0
 * @description
 * @createDate 2020/12/9 21:37
 **/
public class syncProducer {
    public static void main(String[] args) throws Exception {
        // 实例化消息生产者Producer
        DefaultMQProducer producer =new DefaultMQProducer("gourp1");
       // 设置NameServer的地址
        producer.setNamesrvAddr(JmsConfig.NAME_SERVER);
        // 启动Producer实例
        producer.start();
        for (int i=0;i<10;i++){
            /*
            * 参数1  消息的主题  用于区分
            * 参数2  消息的tag  用于区分
            * 参数3  消息的内容
            * */

            Message msg =new Message("group1","TagA",("消息测试"+i).getBytes());
            // 发送消息到一个Broker 同步会等待消息回调
            SendResult sendResult =producer.send(msg);
            // 通过sendResult返回消息是否成功送达
            System.out.printf("%s%n", sendResult);

        }
        // 如果不再发送消息，关闭Producer实例。
        producer.shutdown();
        }

}
