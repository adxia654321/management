package com.practise.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // 允許所有路徑
                        .allowedOrigins("http://localhost:5173") // 允許前端的地址
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 允許的方法
                        .allowCredentials(true); // 如果前端有帶 cookie，這個要設 true
            }
        };
    }
}
