package com.practise.service.impl;

import com.practise.entity.ClazzCountOption;
import com.practise.entity.JobOption;
import com.practise.mapper.EmpMapper;
import com.practise.mapper.StudentMapper;
import com.practise.service.ReportService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;

    @Autowired
    private StudentMapper studentMapper;

    // 統計員工職位人數
    @Override
    public JobOption getEmpJobData() {
        // 1. 調用 mapper interface, 獲取統計數據
        List<Map<String, Object>> list = empMapper.countEmpJobData();

        // 2. 組裝結果, 並返回
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("num")).toList();

        return new JobOption(jobList, dataList);
    }

    // 統計員工性別人數
    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }

    // 統計學生學歷人數
    @Override
    public List<Map<String, Object>> getStudentDegreeData() {
        return studentMapper.getStudentDegreeData();

    }

    // 統計班級人數
    @Override
    public ClazzCountOption getStudentCountData() {
        // 1. 調用 Mapper 的 getStudentCountData方法 獲得班級學生數量的統計資訊
        //    查詢返回結果會是 List<Map<String, Object>> 類型
        List<Map<String, Object>> list = studentMapper.getStudentCountData();

        // 2. 提取班級名稱的列表 轉成List
        List<Object> clazzList = list.stream().map(dataMap -> dataMap.get("cname")).toList();

        // 3. 提取班級人數的列表 轉成List
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("scount")).toList();

        // 4. 再將兩個列表 封裝到 ClazzCountOption 中 並返回
        return new ClazzCountOption(clazzList, dataList);
    }

}
