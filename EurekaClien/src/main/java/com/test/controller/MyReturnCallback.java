package com.test.controller;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class MyReturnCallback implements RabbitTemplate.ReturnCallback {
    /**
     * ReturnCallback回调实现
     * 如果进入此方法了，就一定是发生了异常
     * @param message 发送的消息
     * @param replyCode 错误码
     * @param replyText 错误消息
     * @param exchange 交换机
     * @param routingKey 路由key
     */
    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
        System.out.println("消息转发到队列时，发生了错误....");
        System.out.println("发送的消息体：" + new String(message.getBody()));
        System.out.println("错误码：" + replyCode);
        System.out.println("错误消息：" + replyText);
        System.out.println("交换机：" + exchange);
        System.out.println("路由key：" + routingKey);
    }
}