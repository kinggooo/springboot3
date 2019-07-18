package com.wangnz.springboot.hello.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wangnz.springboot.hello.common.Result;
import com.wangnz.springboot.hello.common.ResultFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@RestController
public class Test1Controller {
    private static Logger log = LoggerFactory.getLogger(Test1Controller.class);

    @RequestMapping(value = "/hello1", method = RequestMethod.POST)
    public JSONObject hello1() throws IOException {
        log.info("hello1 start");
        log.info("hello1 end");
//        return "succ";
        String filePath = "/Users/wangnz/Documents/东财/百行征信/Q1.txt";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "utf-8"));
        StringBuilder result = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            result.append(line).append("\n");
        }
//        res = JSON.parseObject(result.toString().trim(), BodyGuardResponse.class);
//        return ResultFactory.buildSuccessResult("登陆成功。");

        return JSON.parseObject(result.toString().trim());
    }
}
