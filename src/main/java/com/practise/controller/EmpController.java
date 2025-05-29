package com.practise.controller;

import com.practise.entity.Emp;
import com.practise.entity.EmpQueryParam;
import com.practise.entity.PageResult;
import com.practise.entity.Result;
import com.practise.service.EmpService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    // 查詢所有員工
    @GetMapping("/list")
    public Result list(){
        log.info("查詢所有的員工");
        List<Emp> list = empService.findAll();

        return Result.success(list);
    }

    // 分頁查詢
    @GetMapping
    public Result page(EmpQueryParam empQueryParam) {

        log.info("分頁查詢: " + empQueryParam);
        PageResult<Emp> pageResult = empService.page(empQueryParam);

        return Result.success(pageResult);
    }

    // 新增員工
    @PostMapping
    public Result save(@RequestBody Emp emp) {
        log.info("新增員工:{}", emp);
        empService.save(emp);

        return Result.success();
    }

    // 刪除員工
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids) {
        log.info("刪除員工" + ids);
        empService.delete(ids);

        return Result.success();
    }

    // 根據id查詢員工資料
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        log.info("根據ID查詢員工: {} ", id);
        Emp emp = empService.getInfo(id);

        return Result.success(emp);
    }

    // 修改員工
    @PutMapping
    public Result update(@RequestBody Emp emp) {
        log.info("修改員工: {}", emp);
        empService.update(emp);
        return Result.success();
    }

//  @GetMapping
//  public Result page(@RequestParam(defaultValue = "1") Integer page,
//                     @RequestParam(defaultValue = "10") Integer pageSize,
//                     String name, Integer gender,
//                     @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
//                     @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
//
//    log.info("分頁查詢 - page: {}, pageSize: {}, name: '{}', gender: {}, begin: {}, end: {}",
//        page, pageSize, name, gender, begin, end);
//    PageResult<Emp> pageResult = empService.page(page, pageSize, name, gender, begin, end);
//    return Result.success(pageResult);
//
//  }


}
