package com.practise.entity;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClazzCountOption {
    private List clazzList; // 職位列表
    private List dataList;  // 人數列表
}
