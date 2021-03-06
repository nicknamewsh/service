package com.firstspringcloud.springclouddemo.controller;

import com.firstspringcloud.springclouddemo.util.BuinessException;
import com.firstspringcloud.springclouddemo.util.ExceptionUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spring_cloud")
public class TestController {
    private Logger logger = Logger.getLogger(TestController.class);
    @Value("${test.tt}")
    private String msg;
    @Value("${server.port}")
    private String port;

    @RequestMapping("/test")
    public String test(){
        return msg;
    }

    @RequestMapping("/tt")
    public String tt(){
        return "tt";
    }
    //获取随机端口号
    @RequestMapping("/get_random_port")
    public String get_random_port(){
        logger.info("========================================获取随机端口号======================================");
        int a = 1/0;
        return this.port;
    }

    /**
     * 自定义异常处理测试
     * */
    @RequestMapping("/testException")
    public String testException(){
        throw new BuinessException(100,"用户名或密码错误！");
    }
}
