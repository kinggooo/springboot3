package com.wangnz.springboot.hello.service;


import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

/**
 * @description ActiveMQ消息生产者
 * @author WANGNANZHI
 * @date 2019年3月22日 下午13:30:00
 * @Copyright 版权所有 (c) www.ok328.club
 * @memo 无备注说明
 */
@Component
public class ActiveMQQueueProducer {

    private final static Logger logger = LoggerFactory.getLogger(ActiveMQQueueProducer.class);

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    /**
     * 发送队列消息
     *
     * @param destinationName 消息目的地标识
     * @param message         消息文本
     */
    public void sendMsg(String destinationName, String message) {
        logger.info("发布了一条队列{}消息{}。", destinationName, message);
        Destination destination = new ActiveMQQueue(destinationName);
        jmsMessagingTemplate.convertAndSend(destination, message);
    }

}
