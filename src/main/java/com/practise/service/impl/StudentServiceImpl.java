package com.practise.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.practise.entity.PageResult;
import com.practise.entity.Student;
import com.practise.mapper.StudentMapper;
import com.practise.repository.StudentRepository;
import com.practise.service.StudentService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentRepository studentRepository;

    // 分頁查詢學生
    @Override
    public PageResult page(String name, Integer degree, Integer clazzId, Integer page,
            Integer pageSize) {
        // 1. 使用 PageHelper 先設定分頁參數
        PageHelper.startPage(page, pageSize);

        // 2. 調用 Mapper list方法 根據查詢條件 返回學生列表
        List<Student> studentList = studentMapper.list(name, degree, clazzId);

        // 3. 將結果強轉為 page類型   ps. page繼承於list
        Page<Student> p = (Page<Student>)studentList;

        // 4. 封裝分頁結果
        return new PageResult(p.getTotal(), p.getResult());

    }

    // 新增學生
    @Override
    public void save(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentRepository.save(student);
    }

    @Override
    public Student findById(Integer id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new  RuntimeException("查無此學生"));

    }

    // 查詢所有學生
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    // 修改學生信息
    @Override
    public void update(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.update(student);
    }

    // 根據id 刪除學生
    @Override
    public void deleteById(Integer id) {

        studentRepository.deleteById(id);
    }

    // 批量刪除學生
    @Override
    public void deleteByIds(List<Integer> ids) {
        studentRepository.deleteAllById(ids);
    }

    @Override
    public void violationHandle(Integer id, Integer score) {
        studentMapper.updateViolation(id, score);
    }

}
















