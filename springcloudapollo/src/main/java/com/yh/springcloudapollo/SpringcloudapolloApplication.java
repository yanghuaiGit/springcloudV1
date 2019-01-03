package com.yh.springcloudapollo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import com.google.common.base.Charsets;
import com.google.common.base.Strings;

import com.yh.springcloudapollo.config.SampleRedisConfig;
import com.yh.springcloudapollo.filters.ErrorFilter;
import com.yh.springcloudapollo.filters.PostFilter;
import com.yh.springcloudapollo.filters.PreFilter;
import com.yh.springcloudapollo.filters.RouteFilter;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.ApplicationContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


@Configuration
@EnableApolloConfig
@EnableZuulProxy
@SpringBootApplication
public class SpringcloudapolloApplication {
    @Bean
    public PreFilter preFilter() {
        return new PreFilter();
    }
    @Bean
    public PostFilter postFilter() {
        return new PostFilter();
    }
    @Bean
    public ErrorFilter errorFilter() {
        return new ErrorFilter();
    }
    @Bean
    public RouteFilter routeFilter() {
        return new RouteFilter();
    }

    public static void main(String[] args) throws IOException {
        ApplicationContext context = new SpringApplicationBuilder(SpringcloudapolloApplication.class).run(args);

        SampleRedisConfig redisConfig = null;
        try {
            redisConfig = context.getBean(SampleRedisConfig.class);
        } catch (NoSuchBeanDefinitionException ex) {
            System.out.println("SampleRedisConfig is null, 'redis.cache.enabled' must have been set to false.");
        }

        System.out.println("SpringBootSampleApplication Demo. Input any key except quit to print the values. Input quit to exit.");
        while (true) {
            System.out.print("> ");
            String input = new BufferedReader(new InputStreamReader(System.in, Charsets.UTF_8)).readLine();
            if (!Strings.isNullOrEmpty(input) && input.trim().equalsIgnoreCase("quit")) {
                System.exit(0);
            }


            if (redisConfig != null) {
                System.out.println(redisConfig.toString());
            }
        }


    }

}

