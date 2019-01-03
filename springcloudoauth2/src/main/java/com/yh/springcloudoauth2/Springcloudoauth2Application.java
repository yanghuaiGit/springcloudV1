package com.yh.springcloudoauth2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.yh.springcloudoauth2.mapper")
public class Springcloudoauth2Application {

    public static void main(String[] args) {
        SpringApplication.run(Springcloudoauth2Application.class, args);
    }

}

