package com.practise.controller;

import com.practise.anno.Log;
import com.practise.entity.Dept;
import com.practise.entity.Result;
import com.practise.service.DeptServic;
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
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {

    @Autowired
    private DeptServic deptServic;

    @GetMapping
    // 查詢所有部門
    public Result list() {
//    System.out.println("查詢全部部門");
        log.info("查詢全部部門");
        List<Dept> deptList = deptServic.findAll();
        return Result.success(deptList);
    }


    @DeleteMapping("/{id}")
    // 刪除部門
    public Result delete(@PathVariable Integer id) {
        log.info("刪除部門id : " + id);
        deptServic.delete(id);
        return Result.success();
    }


    @PostMapping
    // 新增部門
    public Result add(@RequestBody Dept dept) {
//    System.out.println("新增部門 : " + dept);
        log.info("新增部門 : " + dept);
        deptServic.add(dept);
        return Result.success();
    }

    // 根據 id 查詢部門
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {   // 傳入參數 跟宣告參數名字一致 ("id") 可以省略
//    System.out.println("查詢部門id : " + id);
        log.info("查詢部門id : " + id);
        Dept dept = deptServic.getById(id);
        return Result.success(dept);
    }

    // 修改部門

    @PutMapping
    public Result update(@RequestBody Dept dept) {
        System.out.println("修改參數 : " + dept);
        log.info("修改參數 : " + dept);
        deptServic.update(dept);
        return Result.success();
    }

}




















