package com.practise.entity;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobOption {

    private List jobList;   // 職位列表
    private List dataList;  // 職位人數列表
}
