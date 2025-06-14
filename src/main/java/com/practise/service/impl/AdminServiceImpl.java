package com.practise.service.impl;

import com.practise.entity.Admin;
import com.practise.entity.AdminLoginInfo;
import com.practise.repository.AdminRepository;
import com.practise.service.AdminService;
import com.practise.utils.JwtUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public void save(Admin admin) {
        // 1. 檢查帳號是否已存在
        if (adminRepository.existsByUsername(admin.getUsername())) {
            throw new RuntimeException("帳號已存在");
        }
        adminRepository.save(admin);

    }

    @Override
    public AdminLoginInfo login(Admin admin) {
        // 1. 用 username 查 admin
        Admin a = adminRepository.findByUsername(admin.getUsername());

        // 2. 判斷 admin 是否存在且密碼正確
        if (a != null && a.getPassword().equals(admin.getPassword())) {

            // 3. 產生 JWT Token
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", a.getId());
            claims.put("username", a.getUsername());
            String jwt = JwtUtils.generateToken(claims);

            // 4. 回傳登入資訊
            return new AdminLoginInfo(a.getId(), a.getUsername(), jwt);
        }

        // 5. 登入失敗回傳 null
        return null;
    }

    @Override
    public List<Admin> findAll() {
        return adminRepository.findAll();
    }

}
