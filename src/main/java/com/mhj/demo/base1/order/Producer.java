package com.mhj.demo.base1.order;

import com.mhj.demo.config.JmsConfig;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;

import java.util.List;

/**
 * @author MHJ
 * @version 1.0
 * @description
 * @createDate 2021/1/8 9:27
 **/
public class Producer {
    public static void main(String[] args) throws Exception {
        // 实例化消息生产者Producer
        DefaultMQProducer producer =new DefaultMQProducer("gourp1");
        // 设置NameServer的地址
        producer.setNamesrvAddr(JmsConfig.NAME_SERVER);
        // 启动Producer实例
        producer.start();
        List<OrderStep> orderStepList =OrderStep.buildOrders();

        for(int i=0;i<orderStepList.size();i++){
            //消息内容
            String body =orderStepList.get(i).toString();
            Message message =new Message("orderTopic","order","i"+i,body.getBytes());
//            顺序消息发送步骤
            /**
             *
             * 参数1 消息对象
             * 参数2  消息队列选择器
             * 参数3 选择队列的业务标识（用于区别是哪一个消息）
             */
            SendResult sendResult= producer.send(message, new MessageQueueSelector() {
                /**
                 * @param list 队列消息
                 * @param message  消息对象
                 * @param o 业务标识参数  是send方法的参数传递过来的
                 * @return 结果是发送到哪一个队列？
                 */

                @Override
                public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                    Long id = (Long) o;  //根据订单id选择发送queue
                    long index = id % list.size();
                    return list.get((int) index);
                }
            },orderStepList.get(i).getOrderId());
            System.out.println("发送结果"+sendResult);
        }
        producer.shutdown();
    }
}
