package com.practise.mapper;


import com.practise.entity.EmpExpr;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

// 員工工作經歷Mapper
@Mapper
public interface EmpExprMapper {


    // 批量保存員工的工作經歷
    void insertBatch(List<EmpExpr> exprList);

    void deleteByEmpIds(List<Integer> empIds);
}
