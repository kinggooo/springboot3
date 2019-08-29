package com.wangnz.springboot.hello.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wangnz.springboot.hello.common.Result;
import com.wangnz.springboot.hello.common.ResultFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Test1Controller {
    private static Logger log = LoggerFactory.getLogger(Test1Controller.class);

    @Value("${sb.exportFilePath}")
    private String Q1File;

    @RequestMapping(value = "/hello1", method = RequestMethod.POST)
    public JSONObject hello1() throws IOException {
        log.info("hello1 start");
        log.info("hello1 end");
//        return "succ";
        String filePath = Q1File;
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

    @GetMapping(value = "/uploadC1", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public JSONObject uploadC1() throws Exception {
        System.out.println("接口uploadC1");
        List<String> datas = new ArrayList<>();

//        String jsonStr = JSONObject.toJSONString(loanApplyInfo);
//        Map<String, String> paramMap = JSONObject.parseObject(jsonStr, HashMap.class);
        return JSON.parseObject("");
    }
}
