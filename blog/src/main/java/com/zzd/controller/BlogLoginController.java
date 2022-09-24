package com.zzd.controller;

import com.zzd.domain.ResponseResult;
import com.zzd.domain.entity.User;
import com.zzd.service.BlogLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :zzd
 * @date : 2022/9/24
 */
@RestController
public class BlogLoginController {
    @Autowired
    private BlogLoginService blogLoginService;
    @PostMapping("/login")
    public ResponseResult login(@RequestBody User user) {
        return blogLoginService.login(user);
    }
    @PostMapping("/logout")
    public ResponseResult logout(){
        return blogLoginService.logout();
    }
}
