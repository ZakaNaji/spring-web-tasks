package com.znaji.springwebtasks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;

@SpringBootApplication(exclude = {WebMvcAutoConfiguration.class, DispatcherServletAutoConfiguration.class, ThymeleafAutoConfiguration.class})
public class SpringWebTasksApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWebTasksApplication.class, args);
    }

}
