package com.practise.exception;

import com.practise.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public Result handleException(Exception e) {
        log.error("程式出錯啦 !!" + e);
        return Result.error("出錯啦, 請聯繫創建人~~ : ");
    }

    @ExceptionHandler
    public Result handleDuplicateKeyException(DuplicateKeyException e){
        log.error("程式出錯啦 !!" + e);
        String message = e.getMessage();  // 拿到錯誤信息
        int i = message.indexOf("Duplicate entry");  // 拿到索引位置
        String errMsg = message.substring(i);    // 擷取 Duplicate entry 之後的字段
        String[] arr = errMsg.split(" ");  // 以空字串為分隔 切割成多個string
        return Result.error(arr[2] + "已存在");
    }

    @ExceptionHandler
    public Result handleBusinessExceptoin(BusinessException e){

        return Result.error("請確認(部門/班級)裡無人員資料後 再試一次!");
    }


}
