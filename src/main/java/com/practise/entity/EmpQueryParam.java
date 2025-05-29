package com.practise.entity;


import java.time.LocalDate;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Data
public class EmpQueryParam {

    private Integer page = 1; // 頁碼
    private Integer pageSize = 10; // 每頁展示數
    private String name;  // 姓名
    private Integer gender; // 性別

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin; // 入職時間範圍 開始
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end; // 入質時間範圍 結束


}
