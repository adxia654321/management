package com.practise.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
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
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; //ID

    private String name; //姓名
    private String no; //學號
    private Integer gender; //性別, 1: 男, 2: 女
    private String phone; //手機號
    private String idCard; //身份證號
    private String address; //聯繫地址
    private Integer degree; //最高學歷, 1: 初中, 2: 高中, 3: 二專, 4: 大學, 5: 碩士, 6: 博士

    @Column(name = "violation_count")
    private Short violationCount; //違規次數

    @Column(name = "violation_score")
    private Short violationScore; //違規扣分

    @Column(name = "graduation_date")
    private LocalDate graduationDate; //畢業時間

    @Column(name = "clazz_id")
    private Integer clazzId; //班級ID

    @Column(name = "create_time")
    private LocalDateTime createTime; //創建時間

    @Column(name = "update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime; //修改時間

    @Transient
    private String clazzName; //班級名稱

}
