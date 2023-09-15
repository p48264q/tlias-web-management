package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
//抽取相同路径
@RequestMapping("/emps")
public class EmpController {

    @Autowired
    private EmpService empService;

    @GetMapping("/emps1")
    public Result list1(){
        //List指定java.util包下
        List<Emp> list1 = empService.list1();
        return Result.success(list1);
    }

    @GetMapping
    //get方式不能用对象接收
    //默认值可以用判断实现，也可以用注解@RequestParam(defaultValue="1")实现
    //日期时间类型参数，要成功接收，请求响应部分讲了注解指定前端传递的日期时间格式,@DateTimeFormat(pattern = "yyyy-MM-dd")
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        log.info("分页查询，参数：{},{},{},{},{},{}",page,pageSize,name,gender,begin,end);
        //调用service分页查询
        PageBean pageBean = empService.page(page,pageSize,name,gender,begin,end);
        return Result.success(pageBean);
    }

    //删除员工
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("批量删除操作,ids:{}",ids);
        empService.delete(ids);
        return Result.success();
    }

    //新增员工,@RequestBody实体类接收页面传递的json

    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("新增员工,emp:{}",emp);
        empService.save(emp);
        return Result.success();
    }
}
