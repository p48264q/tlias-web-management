package com.itheima;

import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest//springboot整合单元测试的注解
class SpringbootMybatisQuickstartApplicationTests {

    @Autowired//虽然UserMapper只是接口，但是因为@Mapper标签的作用已经生成实现类对象并且交给了IOC容器管理，所以只用标签自动注入即可
    private UserMapper userMapper;

    @Test
    public void testListUser(){
        List<User> list = userMapper.list();
//        for (User user : list) {
//            System.out.println(user);
//        }

        //基于stream流的写法
        list.stream().forEach(user -> {
            System.out.println(user);
        });

    }

}
