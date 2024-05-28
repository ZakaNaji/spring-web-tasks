package com.znaji.springwebtasks.court.config;

import com.znaji.springwebtasks.court.exception.ReservationNotFoundException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.List;
import java.util.Properties;

@Configuration
public class ExceptionHandlingConfig implements WebMvcConfigurer {

    /*@Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        resolvers.add(handlerExceptionResolver());
    }

    @Bean
    public HandlerExceptionResolver handlerExceptionResolver() {
        var mapping = new Properties();
        mapping.setProperty(ReservationNotFoundException.class.getName(), "reservationNotFound");

        var resolver = new SimpleMappingExceptionResolver();
        resolver.setDefaultErrorView("error.html");
        resolver.setExceptionMappings(mapping);
        return resolver;
    }*/
}
