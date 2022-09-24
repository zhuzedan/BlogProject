package com.zzd.service;

import com.zzd.domain.ResponseResult;
import com.zzd.domain.entity.User;

/**
 * @author :zzd
 * @date : 2022/9/24
 */
public interface BlogLoginService {
    ResponseResult login(User user);
}
