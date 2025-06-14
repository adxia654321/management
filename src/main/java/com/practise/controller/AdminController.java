package com.practise.controller;

import com.practise.entity.Admin;
import com.practise.entity.AdminLoginInfo;
import com.practise.entity.Result;
import com.practise.service.AdminService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/admin")
@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    // 註冊
    @PostMapping("/register")
    public Result save(@RequestBody Admin admin){
        adminService.save(admin);

        return Result.success();
    }

    // 登入
    @PostMapping("/login")
    public Result login(@RequestBody Admin admin){

        AdminLoginInfo info = adminService.login(admin);
        if(info != null){
            return Result.success(info);
        }

        return Result.error("帳號或密碼錯誤 !");
    }

    // 查詢所有admin
    @GetMapping
    public Result list(){

        List<Admin> list = adminService.findAll();

        return Result.success(list);
    }

}
