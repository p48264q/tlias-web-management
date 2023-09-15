package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
//@RestController组合注解是两个注解的效果之和，@ResponseBody的作用就是将返回值对象直接转为json再响应回来
public class DeptController {

    //private static Logger 选择org.slf4j包下的Logger
    //获取日志对象，固定代码,lombok提供@Slf4j注解简化
    //private static Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;

/*
* 查询部门数据
* */

    //通过value属性指定当前接口的请求路径，接口文档已经规定
//    @RequestMapping(value = "/depts",method = RequestMethod.GET)//指定请求路径为GET
    @GetMapping
    public Result list(){
        log.info("查询全部部门数据");

        //调用service查询部门数据
        //List指定java.util包下
        List<Dept> deptList = deptService.list();
        return Result.success(deptList);
    }

    /*
    * 删除部门数据
    * #{id}占位符用于sql语句中
    * */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据id删除部门:{}",id);
        //调用service删除部门
        deptService.delete(id);
        return Result.success();
    }

    /*
    * 添加部门
    * */

    @PostMapping
    //虽参数说明中参数name是string类型的
    //但根据文档页面传递的请求参数是json格式的，所以不能传String。封装到一个实体类中
    //不能存String存疑，https://blog.csdn.net/justry_deng/article/details/80972817
    //上面链接有 @RequestBody直接以String接收前端传过来的json数据 的示例
    //json格式的信息想封装到实体类中需要注解@RequestBody
    //此时调试时postman数据从请求体Body的raw中以json格式封装
    public Result add(@RequestBody Dept dept){
        log.info("新增部门：{}",dept);
        deptService.add(dept);
        //没有return修改之后数据不回显，需要刷新才能显示
        return Result.success();
    }

    /*
    * 修改之ID查询
    * */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }

    //修改
    @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("新增部门：{}",dept);
        deptService.update(dept);
        log.info("qwrerqerqer：{}",dept);
        return Result.success();
    }
}
