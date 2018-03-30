package com.wangnz.springboot.hello.controller;

import com.wangnz.springboot.tools.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test1Controller {
    private static Logger log = LoggerFactory.getLogger(Test1Controller.class);

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        log.info("hello start");
        StringUtils.sayHello();
        log.info("hello end");
        return "hello";
    }
}
