package com.yh.springcloudclient2;


import com.yh.springcloudclient2.versionController.ApiVersion;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@ApiVersion(1)
@RestController
@RequestMapping("{version}")
public class ControllerVersionTest {
    @GetMapping("test")
    public String get(){
        return "version1";
    }
}
