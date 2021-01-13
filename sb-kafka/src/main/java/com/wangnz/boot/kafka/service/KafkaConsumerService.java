package com.wangnz.boot.kafka.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KafkaConsumerService {
    private static Logger log = LoggerFactory.getLogger(KafkaConsumerService.class);
    private static final String TOPIC = "topic02";

    /**
     * 完整consumer
     *
     * @return
     */
//    @KafkaListener(id = "id7", topics = {KafkaConsumerService.TOPIC}, groupId = "group7")
    public boolean consumer4(List<ConsumerRecord<?, ?>> data) {
        for (int i = 0; i < data.size(); i++) {
            ConsumerRecord<?, ?> record = data.get(i);
            Optional<?> kafkaMessage = Optional.ofNullable(record.value());

            Long threadId = Thread.currentThread().getId();
            if (kafkaMessage.isPresent()) {
                Object message = kafkaMessage.get();
                log.info("consumer:group7 --> message:{}, topic:{}, partition:{}, key:{}, offset:{}, threadId:{}", message.toString(), record.topic(), record.partition(), record.key(), record.offset(), threadId);
            }
        }

        return true;
    }

    @KafkaListener(topics = {"topic1"})
    public void consumer5(ConsumerRecord<?, ?> record) {
        // 消费的哪个topic、partition的消息,打印出消息内容
        log.info("简单消费：{}-{}-{}", record.topic(), record.partition(), record.value());
    }

//    /**
//     * 单条消费
//     * @param message
//     */
//    @KafkaListener(id = "id0", topics = {Constant.TOPIC}, containerFactory="kafkaListenerContainerFactory")
//    public void kafkaListener0(String message){
//        log.info("consumer:group0 --> message:{}", message);
//    }
//
//    @KafkaListener(id = "id1", topics = {Constant.TOPIC}, groupId = "group1")
//    public void kafkaListener1(String message){
//        log.info("consumer:group1 --> message:{}", message);
//    }
//    /**
//     * 监听某个 Topic 的某个分区示例,也可以监听多个 Topic 的分区
//     * 为什么找不到group2呢？
//     * @param message
//     */
//    @KafkaListener(id = "id2", groupId = "group2", topicPartitions = { @TopicPartition(topic = Constant.TOPIC, partitions = { "0" }) })
//    public void kafkaListener2(String message) {
//        log.info("consumer:group2 --> message:{}", message);
//    }
//
//    /**
//     * 获取监听的 topic 消息头中的元数据
//     * @param message
//     * @param topic
//     * @param key
//     */
//    @KafkaListener(id = "id3", topics = Constant.TOPIC, groupId = "group3")
//    public void kafkaListener(@Payload String message,
//                              @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
//                              @Header(KafkaHeaders.RECEIVED_PARTITION_ID) String partition,
//                              @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key) {
//        Long threadId = Thread.currentThread().getId();
//        log.info("consumer:group3 --> message:{}, topic:{}, partition:{}, key:{}, threadId:{}", message, topic, partition, key, threadId);
//    }
//
//    /**
//     * 监听 topic 进行批量消费
//     * @param messages
//     */
//    @KafkaListener(id = "id4", topics = Constant.TOPIC, groupId = "group4")
//    public void kafkaListener(List<String> messages) {
//        for(String msg:messages){
//            log.info("consumer:group4 --> message:{}", msg);
//        }
//    }
//
//    /**
//     * 监听topic并手动提交偏移量
//     * @param messages
//     * @param acknowledgment
//     */
//    @KafkaListener(id = "id5", topics = Constant.TOPIC,groupId = "group5")
//    public void kafkaListener(List<String> messages, Acknowledgment acknowledgment) {
//        for(String msg:messages){
//            log.info("consumer:group5 --> message:{}", msg);
//        }
//        // 触发提交offset偏移量
//        acknowledgment.acknowledge();
//    }
//
//    /**
//     * 模糊匹配多个 Topic
//     * @param message
//     */
//    @KafkaListener(id = "id6", topicPattern = "test.*",groupId = "group6")
//    public void annoListener2(String message) {
//        log.error("consumer:group6 --> message:{}", message);
//    }


}