package com.practise.aop;


import com.fasterxml.jackson.databind.introspect.Annotated;
import com.practise.entity.OperateLog;
import com.practise.mapper.OperateLogMapper;
import com.practise.utils.CurrentHolder;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class OperationLogAspect {

    @Autowired
    private OperateLogMapper operateLogMapper;


    @Around("@annotation(com.practise.anno.Log)")
    public Object logOperation(ProceedingJoinPoint joinPoint) throws Throwable {

        // 程式開始時間
        long startTime = System.currentTimeMillis();

        // 執行目標方法
        Object result = joinPoint.proceed();

        // 計算耗時
        long endTime = System.currentTimeMillis();
        long costTime = endTime - startTime;

        // 創建日誌實體物件
        OperateLog olog = new OperateLog();
        olog.setOperateEmpId(getUserId());
        olog.setOperateTime(LocalDateTime.now());
        olog.setClassName(joinPoint.getTarget().getClass().getName());
        olog.setMethodName(joinPoint.getSignature().getName());
        olog.setMethodParams(Arrays.toString(joinPoint.getArgs()));
        olog.setReturnValue(result != null ? result.toString() : "void");
        olog.setCostTime(costTime);

        // 保存日誌
        log.info("紀錄操作日誌: {}", olog);

        operateLogMapper.insert(olog);

        return  result;

    }

    private Integer getUserId(){

        return CurrentHolder.getCurrentId();
    }
}


















