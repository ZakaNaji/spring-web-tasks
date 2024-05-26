package com.znaji.springwebtasks.court.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration

public class CourtConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(extensionInterceptor());
    }

    @Bean
    public ExtensionInterceptor extensionInterceptor() {
        return new ExtensionInterceptor();
    }
}
