package com.firstspringcloud.springclouddemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spring_cloud")
public class TestController {
    @RequestMapping("/test")
    public String test(){
        return "Hello word";
    }

    @RequestMapping("/tt")
    public String tt(){
        return "tt";
    }
}
