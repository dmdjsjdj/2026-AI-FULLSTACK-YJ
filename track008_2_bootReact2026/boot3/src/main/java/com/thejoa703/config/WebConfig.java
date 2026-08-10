package com.thejoa703.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // yml 에서 업로드된 경로 불러오기
    @Value("${file.upload-dir}")
    private String uploadDir;

    // 이미지 리소스 정적 매핑
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploads/**")
                .addResourceLocations("file:" + uploadDir + "/");
    }

    // Cor - 외부에서 접근 가능하게 설정
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**") // 모든 경로에 대해 CORS 설정 적용
//                .allowedOrigins("http://localhost:3000") // 모든 도메인에서 접근 허용 (보안 필요시 특정 도메인만 지정)
//                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS") // 허용할 HTTP 메서드
//                .allowedHeaders("*") // 허용할 헤더
//                .allowCredentials(true)
//                .maxAge(3600); // 프리플라이트(Preflight) 요청 캐시 시간 (초 단위)
//    }
}
