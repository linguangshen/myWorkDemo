package com.test.controller;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Message2 {

    //监听队列
    @RabbitListener(queues = "myQueue")
    public void msg(Message message, Channel channel, String msg) {

        //System.out.println("接收到消息内容为：" + msg);
        try {
            System.out.println("接收到消息内容为：" + msg);
            //处理业务没出错，签收消息
            //basicAck(消息签收标签，是否批量【一般设置为false,表示只签收DeliveryTag的消息】)
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                //1.业务处理异常，拒绝签收,直接丢弃
                //basicNack(消息签收标签，是否批量,是否重回队列)
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, false);
                //2.业务处理异常，拒绝签收,重回队列
                //channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
                //3.业务处理异常，拒绝签收-不支持批量
                //basicReject(消息签收标签，是否重回队列)
                //channel.basicReject(message.getMessageProperties().getDeliveryTag(),false);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
