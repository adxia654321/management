package com.practise.service;

import com.practise.entity.Admin;
import com.practise.entity.AdminLoginInfo;
import java.util.List;

public interface AdminService {

    void save(Admin admin);

    AdminLoginInfo login (Admin admin);

    List<Admin> findAll();

}
