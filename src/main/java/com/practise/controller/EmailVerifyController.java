package com.practise.controller;

import com.practise.entity.Result;
import com.practise.service.MailService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailVerifyController {

    private Map<String, String> verifyCodeStore = new HashMap<>(); // 暫存驗證碼

    @Autowired
    private MailService mailService;

    @PostMapping("/send")
    public Result sendCode(@RequestParam String email) {
        String code = String.valueOf((int)((Math.random() * 900000) + 100000)); // 產生 6 位數
        verifyCodeStore.put(email, code);
        mailService.sendVerificationCode(email, code);
        return Result.success();
    }

    @PostMapping("/check")
    public Result checkCode(@RequestParam String email, @RequestParam String code) {
        String realCode = verifyCodeStore.get(email);
        if (realCode != null && realCode.equals(code)) {
            return Result.success();
        } else {
            return Result.error("驗證碼錯誤或已過期");
        }
    }
}
