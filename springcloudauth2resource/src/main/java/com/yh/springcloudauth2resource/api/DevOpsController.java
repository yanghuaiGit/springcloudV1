package com.yh.springcloudauth2resource.api;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api")
public class DevOpsController {

    @RequestMapping("/userlist")
    @PreAuthorize("#oauth2.hasScope('read')")
    public ResponseEntity<List<UserInfo>> getAllUsers() {
        return ResponseEntity.ok(getUsers());
    }

    private List<UserInfo> getUsers() {
        List<UserInfo> users = new ArrayList<>();
        users.add(new UserInfo("bobo", "bobo@spring2go.com"));
        users.add(new UserInfo("eric", "eric@spring2go.com"));
        users.add(new UserInfo("franky", "franky@spring2go.com"));

        return users;
    }
}