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

@Slf4j
@RestController
public class UploadController {

    // 圖片儲存路徑（建議之後改用 @Value 從設定檔讀取）
    private final String uploadPath = "C:/Users/USER/Desktop/JavaClass/management/management/img/";

    // 網址前綴（用來拼圖片URL）
    private final String imageUrlPrefix = "http://localhost:8080/img/";

    @PostMapping("/upload")
    public Result upload(@RequestParam(required = false) String name,
            @RequestParam(required = false) Integer age,
            @RequestParam MultipartFile file) throws IOException {

        log.info("接收參數: {},{},{}", name, age, file);

        // 1. 檢查檔案
        if (file == null || file.isEmpty()) {
            return Result.error("檔案不能為空");
        }

        // 2. 原始檔案名
        String originalFilename = file.getOriginalFilename();
        if (originalFilename == null || !originalFilename.contains(".")) {
            return Result.error("檔案名稱不合法");
        }

        // 3. 新檔名
        String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
        String newFileName = UUID.randomUUID().toString() + extension;

        // 4. 儲存檔案
        file.transferTo(new File(uploadPath + newFileName));

        // 5. 回傳圖片 URL
        String imageUrl = imageUrlPrefix + newFileName;

        // 你也可以選擇回傳一個物件包含 name、age、imageUrl
        return Result.success(imageUrl);
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

}
