package com.practise.mapper;


import com.practise.entity.Emp;
import com.practise.entity.EmpQueryParam;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

// 員工Mapper
@Mapper
public interface EmpMapper {


    // 條件查詢員工
    public List<Emp> list(EmpQueryParam empQueryParam);

    // 新增員工
    @Options(useGeneratedKeys = true, keyProperty = "id")  // 獲取到主鍵 (mybatis的主鍵返回)
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time)"
            + " values (#{username}, #{name}, #{gender}, #{phone}, #{job}, #{salary}, #{image}, #{entryDate}, #{deptId}, #{createTime}, #{updateTime} )")
    void insert(Emp emp);

    // 根據 id 批量刪除員工
    void deleteByIds(List<Integer> ids);

    // 根據 id 查詢員工
    Emp getById(Integer id);

    // 修改員工
    void updateById(Emp emp);

    // 統計員工職位人數
    @MapKey("pos")
    List<Map<String, Object>> countEmpJobData();

    // 統計員工性別人數
    @MapKey("name")
    List<Map<String, Object>> countEmpGenderData();

    // 查詢所有員工
    @Select("select * from emp")
    List<Emp> findAll();

    // 根據用戶名和密碼 查詢員工資料
    @Select("select id, username, name from emp where username = #{username} and password = #{password}")
    Emp selectByUsernameAndPassword(Emp emp);

    //  public List<Emp> list(String name, Integer gender, LocalDate begin, LocalDate end);

    //---------------------原始分頁查詢方式-----------------------------------------------------

    // 查詢總紀錄數
//  @Select("select COUNT(*) from emp e left join dept d on e.dept_id = d.id ")
//  public Long count();

    // 分頁查詢方法
//  @Select("select e.*,d.name deptName from emp e left join dept d on e.dept_id = d.id "
//      + "order by e.update_time desc limit #{start},#{pageSize}")
//  public List<Emp> list(Integer start, Integer pageSize);

    //---------------------------------------------------------------------------------------

    //@Select("select e.*, d.name deptName from emp e left join dept d on e.dept_id = d.id "
    //   + "order by e.update_time desc ")


}
