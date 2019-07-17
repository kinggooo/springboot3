package com.wangnz.sb.actmq.service;


import com.wangnz.sb.actmq.constant.ActiveMQQueueConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;

/**
 * @description 测试
 * @author WANGNANZHI
 * @date 2019年3月22日 下午13:30:00
 * @Copyright 版权所有 (c) www.ok328.club
 * @memo 无备注说明
 */
@Component
@EnableScheduling
public class ActiveMQTest {

    @Autowired
    private ActiveMQQueueProducer activeMQQueueProducer;

    @Autowired
    private ActiveMQTopicPublisher activeMQTopicPublisher;

    @Scheduled(fixedRate = 5000, initialDelay = 3000)
    public void test() {
        activeMQQueueProducer.sendMsg(ActiveMQQueueConst.QUEUE_NAME_WEBSOCKET_CHATROOM_JAVALSJ,
                "队列message" + Instant.now().toString());
//        activeMQTopicPublisher.publishMsg(ActiveMQTopicConst.TOPIC_NAME_WEBSOCKET_SYSTEM_NOTICE,
//                "主题message" + Instant.now().toString());
    }

}
