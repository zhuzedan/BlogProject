package com.zzd.service;

import com.zzd.domain.ResponseResult;
import com.zzd.domain.entity.User;

/**
 * @author :zzd
 * @date : 2022/9/27
 */
public interface LoginService {
    ResponseResult login(User user);
}
