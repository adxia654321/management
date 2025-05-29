package com.practise.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class Emp {

    private Integer id; // ID
    private String username; // 用戶
    private String password; // 密碼
    private String name; // 姓名
    private Short gender; // 性别 , 1 男, 2 女
    private String image; // 圖像url
    private BigDecimal salary; // 薪水
    private Short job; // 職位
    private LocalDate entryDate; // 入職日期
    private Integer deptId; // 部門ID
    private String phone; // 電話
    private LocalDateTime createTime; // 創建時間
    private LocalDateTime updateTime; // 修改日期

    // 封裝部門名稱
    private String deptName;

    // 封裝工作經歷
    private List<EmpExpr> exprList;

}
