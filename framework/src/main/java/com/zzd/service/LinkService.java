package com.zzd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzd.domain.ResponseResult;
import com.zzd.domain.entity.Link;


/**
 * 友链(Link)表服务接口
 *
 * @author makejava
 * @since 2022-09-23 23:08:41
 */
public interface LinkService extends IService<Link> {


    ResponseResult getAllLink();
}

