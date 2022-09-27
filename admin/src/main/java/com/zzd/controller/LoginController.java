package com.zzd.controller;

import com.zzd.domain.ResponseResult;
import com.zzd.domain.entity.User;
import com.zzd.enums.AppHttpCodeEnum;
import com.zzd.service.LoginService;
import org.omg.CORBA.SystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :zzd
 * @date : 2022/9/27
 */
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user){
        return loginService.login(user);
    }
}
