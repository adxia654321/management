package com.practise.controller;

import com.practise.entity.Result;
import java.io.File;
import java.io.IOException;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

    @Value("${upload.path}")
    private String uploadPath;

    @Value("${upload.url-prefix}")
    private String imageUrlPrefix;

    @PostMapping("/upload")
    public Result upload(@RequestParam(required = false) String name,
                         @RequestParam(required = false) Integer age,
                         @RequestParam MultipartFile file) throws IOException {

        log.info("接收參數: {},{},{}", name, age, file);

        if (file == null || file.isEmpty()) {
            return Result.error("檔案不能為空");
        }

        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null || !originalFilename.contains(".")) {
            return Result.error("檔案名稱不合法");
        }

        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFileName = UUID.randomUUID().toString() + extension;

        file.transferTo(new File(uploadPath + newFileName));

        String imageUrl = imageUrlPrefix + newFileName;
        return Result.success(imageUrl);
    }
}






//    @PostMapping("/upload")
//    public Result upload(String name, Integer age, MultipartFile file) throws IOException {
//
//        log.info("接收參數: {},{},{}", name, age, file);
//        // 獲取原始文件名
//        String originalFilename = file.getOriginalFilename();
//
//        // 新的文件名
//        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
//        String newFileName = UUID.randomUUID().toString() + extension;
//
//        // 保存文件
//        file.transferTo(new File(
//                "C:\\Users\\USER\\Desktop\\JavaClass\\management\\management\\img\\"
//                        + newFileName));
//        return Result.success();
//    }


