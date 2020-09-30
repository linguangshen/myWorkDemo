package com.test.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.stereotype.Component;

@Component
public class MyConfirmCallback implements RabbitTemplate.ConfirmCallback {

    /**
     * ConfirmCallback回调实现
     * @param correlationData 消息信息
     * @param ack 确认标识：true,MQ服务器exchange表示已经确认收到消息 false 表示没有收到消息
     * @param cause 如果没有收到消息，则返回为MQ服务器exchange消息没有收到的原因，如果已经收到则返回为null
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        //如果成功发送消息到交换机
        if (ack) {
            System.out.println("已成功发送消息到交换机," + cause);
        }else {
            System.out.println("发送消息到交换机失败,原因是:" + cause);
        }
    }
}