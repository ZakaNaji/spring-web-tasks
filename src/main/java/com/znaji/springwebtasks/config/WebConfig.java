package com.znaji.springwebtasks.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPath;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final WebMvcProperties webMvcProperties;

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp(webMvcProperties.getView().getPrefix(), webMvcProperties.getView().getSuffix());
    }

    @Bean
    public DispatcherServlet dispatcherServlet() {
        return new DispatcherServlet();
    }

    @Bean
    public DispatcherServletPath dispatcherServletPath() {
        return () -> "";
    }

    @Bean
    public ServletRegistrationBean<DispatcherServlet> dispatcherServletRegistration() {
        ServletRegistrationBean<DispatcherServlet> registration = new ServletRegistrationBean<>(dispatcherServlet(), "/");
        registration.setName(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME);
        registration.setLoadOnStartup(1);
        return registration;
    }
}
