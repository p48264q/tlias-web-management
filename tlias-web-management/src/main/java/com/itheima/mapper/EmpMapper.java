package com.itheima.mapper;

import com.itheima.pojo.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
    @Select("select * from emp")
    List<Emp> list1();

    /*
    * 查询总记录数
    * */
//    @Select("select count(*) from emp")
//    public Long count();
//
//    /*
//    * 分页查询，获取列表数据
//    * */
//    @Select("select * from emp limit #{start},#{pageSize}")
//    public  List<Emp> page(Integer start,Integer pageSize);

    /*
    * 员工信息查询
    * 用动态sql，所以推荐用xml，当选择用xml映射文件定义时，同包同名（）斜杠而非点分隔，文件名与接口一致（约束直接百度）
    * namespace与接口全类名保持一致
    * sql语句的id需要与mapper接口中的方法名保持一致，并且需要保持返回值类型一致(单条记录封装的类型全类型名)
    * */
    //@Select("select * from emp")
    public List<Emp> list(String name, Short gender, LocalDate begin, LocalDate end);

    /*
    * 批量删除
    * */
    void delete(List<Integer> ids);

    //新增员工
    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "VALUES(#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);
}
