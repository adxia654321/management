package com.practise.entity;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperateLog {

    private Integer id;             // ID
    private Integer operateEmpId;   // 操作人ID
    private LocalDateTime operateTime; // 操作時間
    private String className;       // 操作類名
    private String methodName;      // 操作方法名
    private String methodParams;    // 操作方法參數
    private String returnValue;     // 操作方法返回值
    private Long costTime;          // 操作耗時

}
