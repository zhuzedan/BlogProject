package com.zzd.service.impl;

import com.zzd.domain.ResponseResult;
import com.zzd.domain.entity.LoginUser;
import com.zzd.domain.entity.User;
import com.zzd.domain.vo.BlogUserLoginVo;
import com.zzd.domain.vo.UserInfoVo;
import com.zzd.service.LoginService;
import com.zzd.utils.BeanCopyUtils;
import com.zzd.utils.JwtUtil;
import com.zzd.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author :zzd
 * @date : 2022/9/27
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private RedisCache redisCache;
    @Override
    public ResponseResult login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        Authentication authenticate = manager.authenticate(authenticationToken);
        //判断是否认证通过
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("用户名或密码错误");
        }
        //获取userid生成token
        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();
        String id = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(id);
        //把用户信息传入redis
        redisCache.setCacheObject("login:"+id,loginUser);
        //把token封装 返回
        Map<String,String> map = new HashMap<>();
        map.put("token",jwt);
        return ResponseResult.okResult(map);

    }

}
