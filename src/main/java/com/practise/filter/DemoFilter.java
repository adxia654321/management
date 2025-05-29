package com.practise.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;

//@WebFilter(urlPatterns = "/*")   // 攔截所有請求
@Slf4j
public class DemoFilter implements Filter {

    // 初始化方法 web伺服器啟動的時候執行 只會執行一次
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init 初始化方法.....");
    }

    // 攔截請求, 執行, 會執行多次
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
            FilterChain filterChain) throws IOException, ServletException {
        log.info("攔截到了請求......");

        // 放行操作
        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {
        log.info("destroy 銷毀的方法.....");
    }
}
