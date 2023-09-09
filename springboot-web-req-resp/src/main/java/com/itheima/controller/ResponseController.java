package com.itheima.controller;

import com.itheima.pojo.Address;
import com.itheima.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//@RestController
//public class ResponseController {
//    @RequestMapping("/hello")
//    public String hello(){
//        System.out.println("hello world");
//        return  "hello world";
//    }
//
//    @RequestMapping("/getAddr")
//    public Address getAddr(){
//        Address address = new Address();
//        address.setProvince("陕西");
//        address.setCity("西安");
//        return address;
//    }
//
//    @RequestMapping("/listAddr")
//    public List<Address> listAddr(){
//        ArrayList<Address> list = new ArrayList<>();
//
//        Address address = new Address();
//        address.setProvince("陕西");
//        address.setCity("西安");
//
//        Address address1 = new Address();
//        address1.setProvince("广东");
//        address1.setCity("深圳");
//        list.add(address);
//        list.add(address1);
//        return list;
//    }
//}


@RestController
public class ResponseController {
    @RequestMapping("/hello")
    public Result hello(){
        System.out.println("hello world");
        //return  new Result(1,"success","hello world");
        return Result.success("hello world");
    }

    @RequestMapping("/getAddr")
    public Result getAddr(){
        Address address = new Address();
        address.setProvince("陕西");
        address.setCity("西安");
        return Result.success(address);
    }

    @RequestMapping("/listAddr")
    public Result listAddr(){
        ArrayList<Address> list = new ArrayList<>();

        Address address = new Address();
        address.setProvince("陕西");
        address.setCity("西安");

        Address address1 = new Address();
        address1.setProvince("广东");
        address1.setCity("深圳");
        list.add(address);
        list.add(address1);
        return Result.success(list);
    }
}
