package com.zzd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzd.domain.ResponseResult;
import com.zzd.domain.entity.Category;


/**
 * 分类表(Category)表服务接口
 *
 * @author makejava
 * @since 2022-09-23 15:35:22
 */
public interface CategoryService extends IService<Category> {

    ResponseResult getCategoryList();
}

