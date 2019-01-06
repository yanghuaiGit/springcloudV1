package com.yh.springcloudclient2.versionController;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@SpringBootConfiguration
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

//    @Bean
//    public AuthInterceptor interceptor(){
//        return new AuthInterceptor();
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new AuthInterceptor());
//    }


    @Override
    @Bean
    public RequestMappingHandlerMapping requestMappingHandlerMapping() {
        RequestMappingHandlerMapping handlerMapping = new CustomRequestMappingHandlerMapping();
        handlerMapping.setOrder(0);
        handlerMapping.setInterceptors(getInterceptors());
        return handlerMapping;
    }
}
