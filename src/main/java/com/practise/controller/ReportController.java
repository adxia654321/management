package com.practise.controller;

import com.practise.entity.ClazzCountOption;
import com.practise.entity.JobOption;
import com.practise.entity.Result;
import com.practise.service.ReportService;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    // 統計員工職位人數
    @GetMapping("/empJobData")
    public Result getEmpJobData(){
        log.info("統計員工職位人數");
        JobOption jobOption = reportService.getEmpJobData();
        return Result.success(jobOption);
    }

    // 統計員工性別人數
    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        log.info("統計員工性別人數");
        List<Map<String, Object>> list = reportService.getEmpGenderData();

        return Result.success(list);
    }

    // 統計學生學歷人數
    @GetMapping("/studentDegreeData")
    public Result getStudentDegreeData(){
        log.info("統計學生學歷人數");
        List<Map<String, Object>> list = reportService.getStudentDegreeData();

        return Result.success(list);
    }

    // 統計每個班級的人數
    @GetMapping("/studentCountData")
    public Result getStudentCountData(){
        log.info("統計班級人數");
        ClazzCountOption clazzCountOption = reportService.getStudentCountData();

        return Result.success(clazzCountOption);
    }

    
}













