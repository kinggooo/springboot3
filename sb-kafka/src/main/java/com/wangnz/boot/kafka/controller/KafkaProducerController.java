package com.wangnz.boot.kafka.controller;

import com.wangnz.boot.kafka.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@RestController
public class KafkaProducerController {
    @Autowired
    private KafkaProducerService producerService;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;


    @GetMapping("/sync")
    public void sendMessageSync(@RequestParam String topic) throws InterruptedException, ExecutionException, TimeoutException {
        producerService.sendMessageSync(topic, null, "同步发送消息测试");
    }

    @GetMapping("/async")
    public void sendMessageAsync() {
        producerService.sendMessageAsync("test", "异步发送消息测试");
    }

    @GetMapping("/test")
    public void test(@RequestParam String topic, @RequestParam(required = false) Integer partition, @RequestParam(required = false) String key, @RequestParam String message) throws InterruptedException, ExecutionException, TimeoutException {
        producerService.test(topic, partition, key, message);
    }

    // 发送消息
    @GetMapping("/kafka/normal/{message}")
    public void sendMessage1(@PathVariable("message") String normalMessage) {
        kafkaTemplate.send("topic1", normalMessage);
    }

}
