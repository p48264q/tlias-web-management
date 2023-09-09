package com.itheima.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//请求处理类，通过注解标识出来
@RestController
public class HelloController {
    //标识该方法处理的是哪个请求，浏览器请求/hello时就会调用下面的方法
    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello world");
        return "Hello World";
    }
}
