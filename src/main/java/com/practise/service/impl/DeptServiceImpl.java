package com.practise.service.impl;

import com.practise.entity.Dept;
import com.practise.exception.BusinessException;
import com.practise.exception.BusinessException;
import com.practise.mapper.DeptMapper;
import com.practise.service.DeptServic;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl implements DeptServic {

    @Autowired
    private DeptMapper deptMapper;

    // 查詢所有部門
    @Override
    public List<Dept> findAll() {
        List<Dept> deptList = deptMapper.findAll();
        return deptList;
    }

    // 刪除部門
    @Override
    public void delete(Integer id) {
        // 先判斷部門有無員工
        Integer count = deptMapper.countByDeptId(id);
        if(count > 0){
            throw new BusinessException("該部門下仍有員工 刪除失敗!");
        }
        deptMapper.deleteById(id);
    }

    // 新增部門
    @Override
    public void add(Dept dept) {
        // 補全屬性 因為前端拿到的資料只有name
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.insert(dept);
    }

    // 根據id 查詢部門
    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }

    // 更新部門
    @Override
    public void update(Dept dept) {
        // 更新修改時間
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }
}
