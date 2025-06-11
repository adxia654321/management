package com.practise.mapper;

import com.practise.entity.OperateLog;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface OperateLogMapper {

    // 插入日誌
    @Insert("INSERT INTO operate_log (operate_emp_id, operate_time, class_name, method_name, method_params, return_value, cost_time) " +
            "VALUES (#{operateEmpId}, #{operateTime}, #{className}, #{methodName}, #{methodParams}, #{returnValue}, #{costTime})")
    void insert(OperateLog log);

    // 查詢日誌
    @Select("select * from operate_log")
    List<OperateLog> findAll();




}
