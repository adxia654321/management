package com.practise.service.impl;

import com.practise.entity.OperateLog;
import com.practise.mapper.OperateLogMapper;
import com.practise.service.OperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperateLogServiceImpl implements OperateLogService {

    @Autowired
    private OperateLogMapper operateLogMapper;


    @Override
    public List<OperateLog> findAll() {

        List<OperateLog> list = operateLogMapper.findAll();
        return list;

    }
}
