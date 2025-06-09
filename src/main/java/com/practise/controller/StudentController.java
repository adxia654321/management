package com.practise.controller;


import com.practise.entity.PageResult;
import com.practise.entity.Result;
import com.practise.entity.Student;
import com.practise.service.StudentService;
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
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // 查詢所有學生
    @GetMapping("/list")
    public Result findAll(){
        List<Student> studentList = studentService.findAll();

        return Result.success(studentList);
    }

    // 分頁查詢學生
    @GetMapping
    public Result page(String name, Integer degree, Integer clazzId,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize){

        log.info("分頁查詢學生 參數:{},{},{},{},{}",name, degree, clazzId, page , pageSize);
        PageResult pageResult = studentService.page(name, degree, clazzId, page , pageSize);
        return Result.success(pageResult);

    }

    // 新增學生
    @PostMapping
    public Result save(@RequestBody Student student){
        studentService.save(student);

        return Result.success();
    }

    // 根據id查詢學生
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        log.info("根據id查詢學生 id:" + id);
        Student student = studentService.findById(id);

        return Result.success(student);
    }

    // 修改學生信息
    @PutMapping
    public Result update(@RequestBody Student student){
        log.info("修改學生: " + student );
        studentService.update(student);

        return Result.success();
    }

    // 根據id 刪除學生
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("刪除學生 id: " + id);
        studentService.deleteById(id);
        return Result.success();
    }

    // 違規處理
    @PutMapping("/violation/{id}/{score}")
    public Result violationHandle(@PathVariable Integer id, @PathVariable Integer score){
        log.info("違規處理 id: {}, score: {} ", id, score);
        studentService.violationHandle(id, score);

        return Result.success();
    }

    // 批量刪除員工
    @DeleteMapping
    public Result deleteByIds(@RequestParam List<Integer> ids){
        log.info("批量刪除員工id: " + ids);
        studentService.deleteByIds(ids);

        return  Result.success();
    }




}


















