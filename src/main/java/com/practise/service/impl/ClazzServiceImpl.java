package com.practise.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.practise.entity.Clazz;
import com.practise.entity.ClazzQueryParam;
import com.practise.entity.PageResult;
import com.practise.exception.BusinessException;
import com.practise.mapper.ClazzMapper;
import com.practise.repository.ClazzRepository;
import com.practise.repository.StudentRepository;
import com.practise.service.ClazzService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClazzServiceImpl implements ClazzService {

    @Autowired
    private ClazzRepository clazzRepository;

    @Autowired
    private ClazzMapper clazzMapper;

    @Autowired
    private StudentRepository studentRepository;

    // 查詢所有班級
    @Override
    public List<Clazz> findAll() {
        return clazzRepository.findAll();
    }

    // 表單查詢班級
    @Override
    public PageResult<Clazz> page(ClazzQueryParam clazzQueryParam) {

        // 1. 設置分頁參數(pageHelper)
        PageHelper.startPage(clazzQueryParam.getPage(), clazzQueryParam.getPagesize());

        // 2. 執行查詢
        List<Clazz> clazzList = clazzMapper.list(clazzQueryParam);

        // 3. 解析查詢結果 並且封裝物件
        Page<Clazz> p = (Page<Clazz>) clazzList;


        return new PageResult<Clazz>(p.getTotal(), p.getResult());
    }

    // 新增班級
    @Override
    public void save(Clazz clazz) {
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzRepository.save(clazz);
    }

    // 根據id 修改班級
    @Override
    public Clazz findById(Integer id) {
        return clazzRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("找不到該班級 ! "));
    }

    // 修改班級
    @Override
    public void update(Clazz clazz) {
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.update(clazz);
    }

    // 根據id 刪除班級
    @Override
    public void deleteById(Integer id) {
        // 確認班級下有無學生  (學生列表暫未實現)
        // 以下未開發 ...
        Integer count = studentRepository.countByClazzId(id);
        if(count > 0){
            throw new BusinessException("該班級還有學生 刪除失敗!");
        }

        clazzRepository.deleteById(id);
    }

}















