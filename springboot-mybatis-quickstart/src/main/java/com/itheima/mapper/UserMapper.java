package com.itheima.mapper;

import com.itheima.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper //标识出是mybaits的一个mapper接口，程序运行时，会自动生成该接口的实现类对象（代理对象），并且会将该对象交给IOC容器管理
public interface UserMapper {
    //查询全部用户信息
    @Select("select * from user")//表明要进行查询操作
    public List<User> list();
}
