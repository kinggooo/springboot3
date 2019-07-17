package com.wangnz.sb.actmq.service;


import com.wangnz.sb.actmq.constant.ActiveMQTopicConst;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author WANGNANZHI
 * @description ActiveMQ主题消息订阅者
 * @date 2019年3月22日 下午13:30:00
 * @Copyright 版权所有 (c) www.ok328.club
 * @memo 无备注说明
 */
@Component
public class ActiveMQTopicSubscriber {

    private final static Logger logger = LoggerFactory.getLogger(ActiveMQTopicSubscriber.class);

    @JmsListener(destination = ActiveMQTopicConst.TOPIC_NAME_WEBSOCKET_SYSTEM_NOTICE, containerFactory = ActiveMQTopicConst.BEAN_NAME_JMSLISTENERCONTAINERFACTORY)
    public void subscribeTopicWebsocketSystemNoticeMsg(String message) {
        logger.info("1消费了一条主题{}消息{}。", ActiveMQTopicConst.TOPIC_NAME_WEBSOCKET_SYSTEM_NOTICE, message);
    }

    @JmsListener(destination = ActiveMQTopicConst.TOPIC_NAME_WEBSOCKET_SYSTEM_NOTICE, containerFactory = ActiveMQTopicConst.BEAN_NAME_JMSLISTENERCONTAINERFACTORY)
    public void subscribeTopicWebsocketSystemNoticeMsg1(String message) {
        logger.info("2消费了一条主题{}消息{}。", ActiveMQTopicConst.TOPIC_NAME_WEBSOCKET_SYSTEM_NOTICE, message);
    }
}
