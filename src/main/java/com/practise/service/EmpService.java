package com.practise.service;

import com.practise.entity.Emp;
import com.practise.entity.EmpQueryParam;
import com.practise.entity.LoginInfo;
import com.practise.entity.PageResult;
import java.util.List;

public interface EmpService {

    // 分頁查詢
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    // 新增員工
    void save(Emp emp);

    // 批量刪除員工
    void delete(List<Integer> ids);

    // 根據 ID 查詢員工
    Emp getInfo(Integer id);

    // 修改員工
    void update(Emp emp);

    // 查詢所有員工
    List<Emp> findAll();

    // 登入
    LoginInfo login(Emp emp);

    /**
     *
     * @param page 頁碼
     * @param pageSize 每頁的資料筆數
     * @return
     */
//  PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender,
//                      LocalDate begin, LocalDate end);


}
