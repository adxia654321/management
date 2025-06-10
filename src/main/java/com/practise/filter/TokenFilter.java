package com.practise.filter;

import com.practise.utils.CurrentHolder;
import com.practise.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.atn.SemanticContext.OR;
import org.apache.coyote.Request;

@Slf4j
@WebFilter("/*")
public class TokenFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
            FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        // 1. 獲取請求路徑
        String requestURI = request.getRequestURI();   // uri拿到的不是完整路徑 只有請求路徑 /emp/login

        // 2. 是否是登錄的請求, 路徑中包含/login, 就是登入操作, 不驗證, 直接放行
        if(requestURI.contains("/login") || requestURI.contains("/upload") || requestURI.contains("/img")) {
            log.info("直接放行!");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        // 3. 獲取請求頭中的token
        String token = request.getHeader("token");

        // 4. 判斷token是否存在, 如果不存在, 返回錯誤訊息(回應401狀態碼)
        if(token == null || token.isEmpty()){
            log.info("token為空, 返回401");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        // 5. 若token存在 就驗證token, 如果驗證失敗 返回錯誤訊息(回應401狀態碼)
        try {
            Claims claims = JwtUtils.parseToken(token);
            Integer empId = Integer.valueOf(claims.get("id").toString());
            CurrentHolder.setCurrentId(empId);   // 將empId 存到線程裡面
            log.info("當前登入員工Id: {}, 將其存入ThreadLocal", empId);

        }catch (Exception e){
            log.info("token錯誤, 返回401");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }

        // 6. 驗證通過 放行
        log.info("token正確, 放行");
        filterChain.doFilter(servletRequest, servletResponse);

        // 程式走到這裡, 表示已經放行後, 並且執行完指定資源
        // 7. 刪除 ThreadLocal 中的資料, 釋放內存
        CurrentHolder.remove();

    }
}
