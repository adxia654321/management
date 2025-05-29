package com.practise.service;

import com.practise.entity.Dept;
import java.util.List;

public interface DeptServic {


    // 查詢所有部門
    List<Dept> findAll();

    void delete(Integer id);

    void add(Dept dept);

    Dept getById(Integer id);

    void update(Dept dept);
}
