package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import com.itheima.service.impl.EmpServiceA;
import com.itheima.utils.XmlParserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {
    @Autowired //运行时，IOC容器会提供该类型的bean对象，并赋值给该变量-依赖注入
    private EmpService empService;

    @RequestMapping("/listEmp")
    public Result list(){
        //1调用service获取数据
        List<Emp> empList = empService.listEmp();
        //3响应数据
        return  Result.success(empList);
    }
}
//@RestController
//public class EmpController {
//    @RequestMapping("/listEmp")
//    public Result list(){
//
//        //1加载并解析emp.xml，形参内容：加载哪份文件，解析出来的文件封装在哪个对象
//        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
//        System.out.println(file);
//        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
//        //2对数据进行转换处理
//        empList.stream().forEach(emp -> {
//            //处理gender 1：男 ，2：女
//            String gender = emp.getGender();
//            if("1".equals(gender)){
//                emp.setGender("男");
//            }else if("2".equals(gender)){
//                emp.setGender("女");
//            }
//
//            //处理job -1讲师，2班主任，3就业指导
//            String job = emp.getJob();
//            if("1".equals(job)){
//                emp.setJob("讲师");
//            }else if ("2".equals(job)) {
//                emp.setJob("班主任");
//            }else if("3".equals(job)){
//                emp.setJob("就业指导");
//            }
//        });
//        //3响应数据
//        return  Result.success(empList);
//    }
//}
