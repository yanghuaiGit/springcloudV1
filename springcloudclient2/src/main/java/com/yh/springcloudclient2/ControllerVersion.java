package com.yh.springcloudclient2;

import com.yh.springcloudclient2.versionController.ApiVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@ApiVersion(2)
@RestController
@RequestMapping("{version}")
public class ControllerVersion {
    @GetMapping("test")
    public String get(){
        return "version2";
    }
}
