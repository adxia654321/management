package com.practise.entity;

import java.time.LocalDate;
import lombok.Data;

@Data
public class EmpExpr {

    private Integer id; // id
    private Integer empId; // 員工id
    private LocalDate begin; // 開始時間
    private LocalDate end; // 結束時間
    private String company; // 公司名稱
    private String job; // 職位

}
