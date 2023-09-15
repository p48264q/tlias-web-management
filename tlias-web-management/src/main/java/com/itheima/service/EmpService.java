package com.itheima.service;


import com.itheima.pojo.Emp;
import com.itheima.pojo.PageBean;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    List<Emp> list1();

/*
* 分页查询
* */
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    /*
    * 批量删除
    * */
    void delete(List<Integer> ids);

    //新增员工
    void save(Emp emp);
}
