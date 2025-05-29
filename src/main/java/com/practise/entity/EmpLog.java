package com.practise.entity;


import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpLog {

    private Integer id;    // ID
    private LocalDateTime operateTime;  // 操作時間
    private String info;    // 詳細信息

}
