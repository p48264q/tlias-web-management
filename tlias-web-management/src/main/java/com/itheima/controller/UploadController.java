package com.itheima.controller;

import com.itheima.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@Slf4j
public class UploadController {

    @PostMapping("/upload")
    //默认最大1m，大文件需要配置properties
    public Result upload(String username, Integer age, MultipartFile image) throws IOException {
        log.info("文件上传:{},{},{}",username,age,image);
        //获取原始文件名
        String originalFilename = image.getOriginalFilename();

        //防止同名覆盖，构造唯一文件名-uuid(通用唯一识别码，长度固定唯一字符串，不会重复)
        int index = originalFilename.lastIndexOf(".");
        String extname = originalFilename.substring(index);
        String newFileName = UUID.randomUUID().toString() + extname;
        log.info("新文件名:{}",newFileName);

        //将文件转存本地,需要指定文件夹存在
        image.transferTo(new File("E:\\images\\"+newFileName));
        return Result.success();
    }
}
