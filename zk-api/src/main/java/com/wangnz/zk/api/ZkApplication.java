package com.wangnz.zk.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(scanBasePackages = "com.wangnz.zk")
public class ZkApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZkApplication.class, args);
    }

    @RequestMapping(name = "HelloService", method = RequestMethod.GET, path = "/hello")
    public String hello() {
        return "hello";
    }
}