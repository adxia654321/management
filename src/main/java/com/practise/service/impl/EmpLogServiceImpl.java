package com.practise.service.impl;


import com.practise.entity.EmpLog;
import com.practise.mapper.EmpLogMapper;
import com.practise.service.EmpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpLogServiceImpl implements EmpLogService {

    @Autowired
    private EmpLogMapper empLogMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW)  // 需要在一個新的事物運行
    @Override
    public void insertLog(EmpLog empLog) {
        empLogMapper.insert(empLog);
    }

}
