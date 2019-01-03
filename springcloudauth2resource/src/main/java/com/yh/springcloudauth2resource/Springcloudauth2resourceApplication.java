package com.yh.springcloudauth2resource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yh.springcloudauth2resource.mapper")
public class Springcloudauth2resourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springcloudauth2resourceApplication.class, args);
    }

}

