package me.kktrkkt.demobootweb.intercepter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // order : 인터셉터 우선순위 숫자가 낮을수록 우선순위가 높다.
        // path : 인터셉터를 적용할 경로, 제외시킬 수도 있다 -** 모든 하위 경로에 적용, - * 하위경로 첫번째만 적용
        registry.addInterceptor(new CommonInterceptor()).order(0).addPathPatterns("/**");
        registry.addInterceptor(new SampleInterceptor()).order(1).addPathPatterns("/sample");
    }
}
