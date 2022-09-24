package com.zzd.service.impl;

import com.zzd.domain.ResponseResult;
import com.zzd.domain.entity.LoginUser;
import com.zzd.domain.entity.User;
import com.zzd.domain.vo.BlogUserLoginVo;
import com.zzd.domain.vo.UserInfoVo;
import com.zzd.service.BlogLoginService;
import com.zzd.utils.BeanCopyUtils;
import com.zzd.utils.JwtUtil;
import com.zzd.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author :zzd
 * @date : 2022/9/24
 */
@Service("blogLoginService")
public class BlogLoginServiceImpl implements BlogLoginService {
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
        redisCache.setCacheObject("bloglogin:"+id,loginUser);
        //把User转换成UserInfoVo
        UserInfoVo userInfoVo = BeanCopyUtils.copyBean(loginUser.getUser(), UserInfoVo.class);
        //把token和userinfo封装
        BlogUserLoginVo userLoginVo = new BlogUserLoginVo(jwt,userInfoVo);

        return ResponseResult.okResult(userLoginVo);
    }

    @Override
    public ResponseResult logout() {
        //获取token 解析获取userid
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        //获取userid
        Long userId = loginUser.getUser().getId();
        //删除redis中的用户信息
        redisCache.deleteObject("bloglogin:"+userId);
        return ResponseResult.okResult();
    }
}
