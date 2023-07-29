package me.kktrkkt.demobootweb.resource_handler;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/kktrkkt/**") // url 패턴
                .addResourceLocations("classpath:/kktrkkt/") // 리소스 위치
                .setCacheControl(CacheControl.maxAge(10, TimeUnit.MINUTES)) // 캐싱 타임
                .resourceChain(true); // 리소스 캐싱 여부
    }
}
