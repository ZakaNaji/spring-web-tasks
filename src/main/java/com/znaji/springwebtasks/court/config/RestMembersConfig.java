package com.znaji.springwebtasks.court.config;

import com.znaji.springwebtasks.court.demain.Member;
import com.znaji.springwebtasks.court.demain.Members;
import jakarta.xml.bind.Marshaller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.xml.MarshallingView;


import java.util.Map;

@Configuration
public class RestMembersConfig implements WebMvcConfigurer { }
