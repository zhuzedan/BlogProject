package com.zzd.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzd.domain.ResponseResult;
import com.zzd.domain.entity.User;
import com.zzd.domain.vo.UserInfoVo;
import com.zzd.mapper.UserMapper;
import com.zzd.service.UserService;
import com.zzd.utils.BeanCopyUtils;
import com.zzd.utils.SecurityUtils;
import org.springframework.stereotype.Service;

/**
 * 用户表(User)表服务实现类
 *
 * @author zzd
 * @since 2022-09-24 15:20:11
 */
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public ResponseResult userInfo() {
        Long userId = SecurityUtils.getUserId();
        User user = getById(userId);
        UserInfoVo vo = BeanCopyUtils.copyBean(user,UserInfoVo.class);
        return ResponseResult.okResult(vo);
    }
}

