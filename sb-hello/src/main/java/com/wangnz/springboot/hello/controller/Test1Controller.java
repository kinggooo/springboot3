package com.wangnz.springboot.hello.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test1Controller {
    private static Logger log = LoggerFactory.getLogger(Test1Controller.class);

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String hello1() {
        log.info("hello1 start");
        log.info("hello1 end");
        return "succ";
    }
}
