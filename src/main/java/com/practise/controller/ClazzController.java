package com.practise.controller;


import com.practise.entity.Clazz;
import com.practise.entity.ClazzQueryParam;
import com.practise.entity.PageResult;
import com.practise.entity.Result;
import com.practise.service.ClazzService;
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
@RestController
@RequestMapping("/clazzs")
public class ClazzController {

    @Autowired
    private ClazzService clazzService;


    // 查詢所有班級
    @GetMapping("/list")
    public Result list(){
        log.info("查詢所有班級");
        List<Clazz> list = clazzService.findAll();
        return Result.success(list);
    }

    // 分頁查詢班級
    @GetMapping
    public Result page(ClazzQueryParam clazzQueryParam){

        log.info("分頁查詢: " + clazzQueryParam);
        PageResult<Clazz> pageResult = clazzService.page(clazzQueryParam);

        return Result.success(pageResult);
    }
    
    // 新增班級
    @PostMapping
    public Result save(@RequestBody Clazz clazz){
        log.info("新增班級: " + clazz);
        clazzService.save(clazz);

        return Result.success();
    }

    // 根據id 查詢班級
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("根據id查詢班級:" + id);
        Clazz clazz = clazzService.findById(id);

        return Result.success(clazz);
    }

    // 更新班級
    @PutMapping
    public Result update(@RequestBody Clazz clazz){
        log.info("更新班級資訊" + clazz);
        clazzService.update(clazz);

        return Result.success();
    }

    // 根據id 刪除班級
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根據id刪除班級 id: " + id);
        clazzService.deleteById(id);

        return Result.success();
    }

    // github測試
    // github測試2

}















