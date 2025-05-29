package com.practise.service;


import com.practise.entity.PageResult;
import com.practise.entity.Student;
import java.util.List;

public interface StudentService {

    // 分頁查詢學生
    PageResult page(String name, Integer degree, Integer clazzId, Integer page, Integer pageSize);

    // 新增學生
    void save(Student student);

    // 根據id查詢學生
    Student findById(Integer id);

    // 查詢所有學生
    List<Student> findAll();

    // 修改學生信息
    void update(Student student);

    // 根據id 刪除學生
    void deleteById(Integer id);

    // 違規處理
    void violationHandle(Integer id, Integer score);
}
