package com.smhrd.dream.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//스프링 서버 전역적으로 CORS 설정
@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
        	.allowedOrigins("http://localhost:3000"
        			,"https://greenote.site"
        			,"http://15.164.213.225:3000") // 허용할 출처
            .allowedMethods("GET", "POST") // 허용할 HTTP method
            .allowedHeaders("*")
            .allowCredentials(true) // 쿠키 인증 요청 허용
            .maxAge(3000); // 원하는 시간만큼 pre-flight 리퀘스트를 캐싱
    }
}
