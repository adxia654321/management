package com.practise.mapper;

import com.practise.entity.Dept;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface DeptMapper {

    // 查詢所有部門
    @Select("select id, name, create_time , update_time from  dept order by update_time desc ")
    List<Dept> findAll();

    // 刪除部門
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    // 新增部門
    @Insert("insert into dept(name, create_time, update_time) values (#{name}, #{createTime}, #{updateTime})")
    void insert(Dept dept);

    // 根據 id 查詢單筆部門
    @Select("select id, name, create_time , update_time from dept where id = #{id}")
    Dept getById(Integer id);

    // 修改單筆部門
    @Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id}")
    void update(Dept dept);

    // 根據id 查詢該部門員工數量
    @Select("select count(*) from emp where dept_id = #{deptId} ")
    Integer countByDeptId(Integer deptId);
}
