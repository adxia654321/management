package com.practise.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * 後端統一返回結果
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    private Integer code; // 1為成功 0為失敗
    private String msg;   // 錯誤訊息
    private Object data;  // 資料


    public static Result success() {
        Result result = new Result();
        result.code = 1;
        result.msg = "success";
        return result;
    }

    public static Result success(Object object) {
        Result result = new Result();
        result.data = object;
        result.code = 1;
        result.msg = "success";
        return result;
    }

    public static Result error(String msg) {
        Result result = new Result();
        result.msg = msg;
        result.code = 0;
        return result;
    }


}
