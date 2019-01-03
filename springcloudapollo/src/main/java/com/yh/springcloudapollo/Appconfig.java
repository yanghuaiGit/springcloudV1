package com.yh.springcloudapollo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
@EnableApolloConfig
public class Appconfig {

        @Bean
        public com.yh.springcloudapollo.TestJavaConfigBean javaConfigBean() {
            return new com.yh.springcloudapollo.TestJavaConfigBean();

    }
}
