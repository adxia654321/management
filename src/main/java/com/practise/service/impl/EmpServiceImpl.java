package com.practise.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.practise.entity.Emp;
import com.practise.entity.EmpExpr;
import com.practise.entity.EmpLog;
import com.practise.entity.EmpQueryParam;
import com.practise.entity.LoginInfo;
import com.practise.entity.PageResult;
import com.practise.mapper.EmpExprMapper;
import com.practise.mapper.EmpMapper;
import com.practise.service.EmpLogService;
import com.practise.service.EmpService;
import com.practise.utils.JwtUtils;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private EmpExprMapper empExprMapper;

    @Autowired
    private EmpLogService empLogService;

    // pageHelper分頁查詢
    @Override
    public PageResult<Emp> page(EmpQueryParam empQueryParam) {

        // 1. 設置分頁參數(pageHelper)
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());

        // 2. 執行查詢
        List<Emp> empList = empMapper.list(empQueryParam);

        // 3. 解析查詢結果, 並且封裝物件
        Page<Emp> p = (Page<Emp>) empList;

        return new PageResult<Emp>(p.getTotal(), p.getResult());

    }

    // 新增員工
    @Override
    @Transactional(rollbackFor = {Exception.class})
    // 事務註解 --  若沒指定 默認 RuntimeException 才會 RollBack
    public void save(Emp emp) {

        try {
            // 1. 保存員工基本資料
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            empMapper.insert(emp);

            // 2. 保存員工工作經歷
            List<EmpExpr> exprList = emp.getExprList();
            if (!exprList.isEmpty()) {
                exprList.forEach(empExpr -> {
                    empExpr.setEmpId(emp.getId());
                });
                empExprMapper.insertBatch(exprList);
            }
        } finally {
            // 3. 紀錄操作日誌
            EmpLog empLog = new EmpLog(null, LocalDateTime.now(), "新增員工" + emp);
            empLogService.insertLog(empLog);
        }


    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public void delete(List<Integer> ids) {

        // 刪除員工信息
        empMapper.deleteByIds(ids);
        //刪除員工經歷
        empExprMapper.deleteByEmpIds(ids);

    }

    // 根據 ID 查詢員工
    @Override
    public Emp getInfo(Integer id) {

        return empMapper.getById(id);
    }

    // 修改員工
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Emp emp) {
        // 1.根據ID修改員工的資料
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateById(emp);

        // 2.根據ID修改員工的工作經歷
        //   先刪除
        empExprMapper.deleteByEmpIds(Arrays.asList(emp.getId()));

        //   在新增
        List<EmpExpr> exprList = emp.getExprList();
        if (!exprList.isEmpty()) {
            exprList.forEach(expr -> expr.setEmpId(emp.getId()));
            empExprMapper.insertBatch(exprList);
        }
    }

    // 查詢所有員工
    @Override
    public List<Emp> findAll() {
        return empMapper.findAll();
    }

    // 登入
    @Override
    public LoginInfo login(Emp emp) {
        // 1. 調用 empMapper 獲得帳號或密碼
        Emp e = empMapper.selectByUsernameAndPassword(emp);

        // 2. 判斷員工是否存在 如果存在 組裝登入信息
        if(e != null){
            log.info("登入成功 員工信息:" + emp);
            // 生成 JWT 通行證
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", e.getId());
            claims.put("username", e.getUsername());
            String jwt = JwtUtils.generateToken(claims);

            return new LoginInfo(e.getId(), e.getUsername(), e.getName(), jwt);
        }

        // 3. 不存在 返回null
        return null;
    }

    /**
     * 原始的分頁查詢代碼
     * @param page 頁碼
     * @param pageSize 每頁的資料筆數
     * @return
     */
//  @Override
//  public PageResult<Emp> page(Integer page, Integer pageSize) {
//
//    // 1. 調用mapper接口, 查詢總紀錄數
//    Long total = empMapper.count();
//
//    // 2. 調用mapper接口, 查詢結果列表
//    Integer start = (page - 1) * pageSize;  // 前端傳來的 page 是第幾頁 要計算轉換成 sql limit起始筆數
//    List<Emp> rows = empMapper.list(start, pageSize);
//
//    // 3. 封裝到 PageResult 物件
//    return new PageResult<Emp>(total, rows);
//
//  }

//  @Override
//  public PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender,
//      LocalDate begin, LocalDate end) {
//
//      // 1. 設置分頁參數(pageHelper)
//      PageHelper.startPage(page, pageSize);
//
//      // 2. 執行查詢
//      List<Emp> empList = empMapper.list(name , gender, begin, end);
//
//      // 3. 解析查詢結果, 並且封裝物件
//      Page<Emp> p = (Page<Emp>)empList;
//
//      return new PageResult<Emp>(p.getTotal(), p.getResult());
//
//  }


}
