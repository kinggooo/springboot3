package com.wangnz.sb.actmq.service;

import org.apache.activemq.command.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Destination;

/**
 * @description ActiveMQ主题消息发布者
 * @author WANGNANZHI
 * @date 2019年3月22日 下午13:30:00
 * @Copyright 版权所有 (c) www.ok328.club
 * @memo 无备注说明
 */
@Component
public class ActiveMQTopicPublisher {
    private final static Logger logger = LoggerFactory.getLogger(ActiveMQTopicPublisher.class);

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    /**
     * 发布主题消息
     */
    public void publishMsg(String destinationName, String message) {
        logger.info("发布了一条主题{}消息{}。", destinationName, message);
        Destination destination = new ActiveMQTopic(destinationName);
        jmsMessagingTemplate.convertAndSend(destination, message);
    }
}
