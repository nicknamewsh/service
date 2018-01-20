package com.firstspringcloud.springclouddemo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spring_cloud")
public class TestController {
    @Value("${test.tt}")
    private String msg;
    @RequestMapping("/test")
    public String test(){
        return msg;
    }

    @RequestMapping("/tt")
    public String tt(){
        return "tt";
    }
}
