package com.wangnz.springboot.hello.service;


import com.wangnz.springboot.hello.constant.ActiveMQQueueConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @description ActiveMQ队列消息消费者
 * @author WANGNANZHI
 * @date 2019年3月22日 下午13:30:00
 * @Copyright 版权所有 (c) www.ok328.club
 * @memo 无备注说明
 */
@Component
public class ActiveMQQueueConsumer {

    private final static Logger logger = LoggerFactory.getLogger(ActiveMQQueueConsumer.class);

    /**
     * WebSocket的Java老司机聊天室队列消息消费者
     */
    @JmsListener(destination = ActiveMQQueueConst.QUEUE_NAME_WEBSOCKET_CHATROOM_JAVALSJ, containerFactory = ActiveMQQueueConst.BEAN_NAME_JMSLISTENERCONTAINERFACTORY)
    public void consumer1(String message) {
        logger.info("consumer1 消费了一条队列{}消息{}。", ActiveMQQueueConst.QUEUE_NAME_WEBSOCKET_CHATROOM_JAVALSJ, message);
    }

    /**
     * WebSocket的Java老司机聊天室队列消息消费者
     */
    @JmsListener(destination = ActiveMQQueueConst.QUEUE_NAME_WEBSOCKET_CHATROOM_JAVALSJ, containerFactory = ActiveMQQueueConst.BEAN_NAME_JMSLISTENERCONTAINERFACTORY)
    public void consumer2(String message) {
        logger.info("consumer2 消费了一条队列{}消息{}。", ActiveMQQueueConst.QUEUE_NAME_WEBSOCKET_CHATROOM_JAVALSJ, message);
    }

}
