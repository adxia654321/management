package com.practise.controller;

import com.practise.entity.Result;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
public class UploadController {

    @PostMapping("/upload")
    public Result upload(String name, Integer age, MultipartFile file) throws IOException {

        log.info("接收參數: {},{},{}", name, age, file);
        // 獲取原始文件名
        String originalFilename = file.getOriginalFilename();

        // 新的文件名
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFileName = UUID.randomUUID().toString() + extension;

        // 保存文件
        file.transferTo(new File(
                "C:\\Users\\USER\\Desktop\\JavaClass\\management\\management\\img\\"
                        + newFileName));
        return Result.success();
    }

}
