package com.practise.mapper;

import com.practise.entity.Student;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StudentMapper {

    // 分頁查詢學生
    List<Student> list(String name, Integer degree, Integer clazzId);

    // 修改學生信息
    void update(Student student);

    // 違規處理
    @Update("update student set violation_count = violation_count + 1, violation_score = violation_score"
            + " + #{score}, update_time = now() where id = #{id}")
    void updateViolation(Integer id, Integer score);

    // 統計學生學歷人數
    @MapKey("name")
    List<Map<String, Object>> getStudentDegreeData();

    // 統計班級學生人數
    @MapKey("name")
    List<Map<String, Object>> getStudentCountData();
}
