package com.zzd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzd.entity.Article;
import com.zzd.entity.ResponseResult;

public interface ArticleService extends IService<Article> {
    ResponseResult hotArticleList();
}
