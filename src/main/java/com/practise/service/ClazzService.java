package com.practise.service;

import com.practise.entity.Clazz;
import com.practise.entity.ClazzQueryParam;
import com.practise.entity.PageResult;
import java.util.List;


public interface ClazzService {

    List<Clazz> findAll();

    // 分頁查詢
    PageResult<Clazz> page(ClazzQueryParam clazzQueryParam);

    // 新增班級
    void save(Clazz clazz);

    // 根據id查詢班級
    Clazz findById(Integer id);

    // 修改班級
    void update(Clazz clazz);

    // 根據id 刪除班級
    void deleteById(Integer id);
}
