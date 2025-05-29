package com.practise.interceptor;

import com.practise.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {

//        // 1. 獲取請求路徑
//        String requestURI = request.getRequestURI();   // uri拿到的不是完整路徑 只有請求路徑 /emp/login
//
//        // 2. 是否是登錄的請求, 路徑中包含/login, 就是登入操作, 不驗證, 直接放行
//        if(requestURI.contains("/login")) {
//            log.info("登入請求, 放行!");
//
//            return true;
//        }

        // 3. 獲取請求頭中的token
        String token = request.getHeader("token");

        // 4. 判斷token是否存在, 如果不存在, 返回錯誤訊息(回應401狀態碼)
        if(token == null || token.isEmpty()){
            log.info("token為空, 返回401");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        // 5. 若token存在 就驗證token, 如果驗證失敗 返回錯誤訊息(回應401狀態碼)
        try {
            JwtUtils.parseToken(token);
        }catch (Exception e){
            log.info("token錯誤, 返回401");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        // 6. 驗證通過 放行
        log.info("token正確, 放行");
        return true;

    }
}
