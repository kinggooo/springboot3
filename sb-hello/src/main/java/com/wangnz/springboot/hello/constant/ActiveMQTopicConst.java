package com.wangnz.springboot.hello.constant;

/**
 * @description ActiveMQ主题常量
 * @author WANGNANZHI
 * @date 2019年3月22日 下午13:30:00
 * @Copyright 版权所有 (c) www.ok328.club
 * @memo 无备注说明
 */
public class ActiveMQTopicConst {

    /**
     * 在Topic模式中，对消息的监听需要对containerFactory进行配置，工厂标识
     */
    public static final String BEAN_NAME_JMSLISTENERCONTAINERFACTORY = "topicJmsListenerContainerFactory";

    /**
     * 主题消息标识_WebSocket的系统公告
     */
    public static final String TOPIC_NAME_WEBSOCKET_SYSTEM_NOTICE = "topic.websocket.system.notice";
}

