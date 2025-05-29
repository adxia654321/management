package com.practise.controller;

import com.practise.entity.Emp;
import com.practise.entity.LoginInfo;
import com.practise.entity.Result;
import com.practise.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    // 登入
    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        log.info("登入 :" + emp);
        LoginInfo info = empService.login(emp);
        if(info != null){
            return Result.success(info);
        }

        return Result.error("用戶名或密碼錯誤 !");
    }
}
