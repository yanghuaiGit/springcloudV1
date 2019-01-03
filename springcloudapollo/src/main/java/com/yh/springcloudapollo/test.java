package com.yh.springcloudapollo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController


public class test {

    @Autowired
    private TestJavaConfigBean testJavaConfigBean;
    @RequestMapping("hello")
    public String hello(){
        return "hello world！"+testJavaConfigBean.getTimeout()+"" +
                ""+testJavaConfigBean.getBatch();
    }

}
