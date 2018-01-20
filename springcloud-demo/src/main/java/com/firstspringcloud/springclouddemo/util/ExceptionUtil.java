package com.firstspringcloud.springclouddemo.util;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;





@ControllerAdvice
public class ExceptionUtil {

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map<String,Object> showAllError(Exception ex){
        Map<String,Object> map = new HashMap<>();
        map.put("code",-1);
        map.put("msg",ex.getMessage());
        return map;
    }

    /**
     * 自定义异常
     * */
    @ResponseBody
    @ExceptionHandler(value = BuinessException.class)
    public Map<String,Object> showAllError(BuinessException ex){
        Map<String,Object> map = new HashMap<>();
        map.put("code",ex.getCode());
        map.put("msg",ex.getMsg());
        return map;
    }
}
