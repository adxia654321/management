package com.practise.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "clazz")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Clazz {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;  // ID
    private String name; // 班級名稱
    private String room; // 班級教室
    private Integer subject;  // 學科
    private String masterName; // 班主任名稱

    @Transient
    private String status; // 班級狀態 - 未開班, 在讀中, 以結課

    @Column(name = "create_time")
    private LocalDateTime createTime; // 創建時間

    @Column(name = "update_time")
    private LocalDateTime updateTime; // 修改時間

    @Column(name = "master_id")
    private Integer masterId; // 班主任

    @Column(name = "begin_date")
    private LocalDate beginDate; // 開課時間

    @Column(name = "end_date")
    private LocalDate endDate; // 結課時間

}


















