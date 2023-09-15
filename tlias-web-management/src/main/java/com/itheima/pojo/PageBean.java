package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*
* 分页查询结果封装类
* */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean {
    //属性名要与接口文档对应
    private Long total;//总记录数
    private List rows;//数据列表
}
