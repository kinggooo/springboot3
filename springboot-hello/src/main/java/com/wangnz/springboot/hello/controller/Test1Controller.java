package com.wangnz.springboot.hello.controller;

import com.wangnz.springboot.hello.config.MultiRequestBody;
import com.wangnz.springboot.hello.pojo.Book;
import com.wangnz.springboot.hello.pojo.Paper;
import com.wangnz.springboot.hello.pojo.Student;
import com.wangnz.springboot.tools.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "系统安全-角色管理", description = "RoleController")
@RestController
public class Test1Controller {
    private static Logger log = LoggerFactory.getLogger(Test1Controller.class);

    @ApiOperation(value = "简单的输入什么id就输出什么", notes = "没什么啦……", httpMethod = "GET")
    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String hello1(@ApiParam(name = "token", value = "token", required = true) @RequestParam(name = "token", required = true) String token) {
        log.info("hello1 start");
        StringUtils.sayHello();
        log.info("hello1 end");
        return token;
    }

    @ApiOperation(value = "hello接口")
    @RequestMapping(value = "/hello2", method = RequestMethod.GET)
    public String hello2(@ApiParam(name = "token", value = "token", required = true) String token) {
        log.info("hello2 start");
        StringUtils.sayHello();
        log.info("hello2 end");
        return token;
    }

    @RequestMapping(value = "/test1", method = RequestMethod.POST)
    public String test1(@MultiRequestBody Book book, @MultiRequestBody Paper paper) {
        return "test1";
    }

    @RequestMapping(value = "/test2", method = RequestMethod.POST)
    @ResponseBody
    public String test2(@RequestBody List<Student> students) {
        log.info("test22");
        return "";
    }

    @RequestMapping(value = "/test3", method = RequestMethod.POST)
    @ResponseBody
    public String test3(String name) {
        log.info("test33");
        return "";
    }
}
