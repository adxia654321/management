package com.practise.controller;

import com.practise.entity.OperateLog;
import com.practise.entity.Result;
import com.practise.service.OperateLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/operateLog")
public class OperateLogController {

    @Autowired
    private OperateLogService operateLogService;

    @GetMapping
    public Result list(){
        List<OperateLog> list = operateLogService.findAll();
        return Result.success(list);
    }

}
