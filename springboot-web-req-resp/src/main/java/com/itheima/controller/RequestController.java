package com.itheima.controller;

import com.itheima.pojo.User;
import com.itheima.pojo.User1;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
//原始方式
//@RestController
//public class RequestController {
//    //获取请求参数
//    @RequestMapping("/simpleParam")
//    public String simpleParam(HttpServletRequest request){
//        String name = request.getParameter("name");
//        String age = request.getParameter("age");
//        int i = Integer.parseInt(age);
//        System.out.println(name+":"+i);
//        return "ok";
//    }
//}

//基于springboot方式，会自动类型转换
@RestController
public class RequestController {
//    //获取请求参数
//    @RequestMapping("/simpleParam")
//    public String simpleParam(String name,Integer age){
//
//        System.out.println(name+":"+age);
//        return "ok";
//    }

    //获取请求参数
    //注解实现映射，解决名称不匹配
    @RequestMapping("/simpleParam")
    public String simpleParam(@RequestParam(name="name",required = false) String username, Integer age){

        System.out.println(username+":"+age);
        return "ok";
    }
    //2.实体参数
    @RequestMapping("/simplePojo")
    public String simplePojo(User user){
        System.out.println(user);
        return "ok";
    }

    //2.复杂实体参数
    @RequestMapping("/complexPojo")
    public String complexPojo(User user){
        System.out.println(user);
        return "ok";
    }

    //3.数组集合参数
    @RequestMapping("/arrayParam")
    public String arrayParam(String[] hobby){
        System.out.println(Arrays.toString(hobby));
        return "ok";
    }

    @RequestMapping("/listParam")
    public String listParam(@RequestParam List<String> hobby){
        System.out.println(hobby);
        return "ok";
    }

    //4.日期事件参数
    @RequestMapping("/dateParam")
    public String dateParam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime updateTime){
        System.out.println(updateTime);
        return "ok";
    }
    //5.json参数
    @RequestMapping("/jsonParam")
    public String jsonParam(@RequestBody User1 user1){
        System.out.println(user1);
        return "ok";
    }
    //6.路径参数
    @RequestMapping("/path/{id}")
    //通过@PathVariable注解获取到路径参数并且将路径参数的值绑定到方法的形参
    public String pathParam(@PathVariable Integer id){
        System.out.println(id);
        return "ok";
    }
    @RequestMapping("/path/{id}/{name}")
    public String pathParam2(@PathVariable Integer id,@PathVariable String name){
        System.out.println(id+":"+name);
        return "ok";
    }
}