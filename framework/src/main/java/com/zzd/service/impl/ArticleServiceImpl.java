package com.zzd.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzd.constants.SystemConstants;
import com.zzd.domain.entity.Article;
import com.zzd.domain.ResponseResult;
import com.zzd.domain.vo.ArticleListVo;
import com.zzd.domain.vo.HotArticleVo;
import com.zzd.domain.vo.PageVo;
import com.zzd.mapper.ArticleMapper;
import com.zzd.service.ArticleService;
import com.zzd.utils.BeanCopyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {

    @Override
    public ResponseResult hotArticleList() {
        //查询热门文章，封装成ResponseResult返回
        LambdaQueryWrapper<Article> wrapper = new LambdaQueryWrapper<>();
        //浏览量排序
        wrapper.eq(Article::getStatus, SystemConstants.ARTICLE_STATUS_NORMAL);
        wrapper.orderByDesc(Article::getViewCount);
        Page<Article> page = new Page(1,10);
        page(page,wrapper);

        List<Article> articles = page.getRecords();
        //bean拷贝
        // List<HotArticleVo> articleVos = new ArrayList<>();
        // for (Article article : articles) {
        //     HotArticleVo vo = new HotArticleVo();
        //     BeanUtils.copyProperties(article,vo);
        //     articleVos.add(vo);
        // }
        List<HotArticleVo> hotArticleVo = BeanCopyUtils.copyBeanList(articles,HotArticleVo.class);

        // return ResponseResult.okResult(articles);
        return ResponseResult.okResult(hotArticleVo);
    }

    @Override
    public ResponseResult articleList(Integer pageNum, Integer pageSize, Long categoryId) {
        //查询条件
        LambdaQueryWrapper<Article> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //如果有categoryId就要查询时和传入的相同
        lambdaQueryWrapper.eq(Objects.nonNull(categoryId)&&categoryId>0, Article::getCategoryId,categoryId);
        //状态是发布的
        lambdaQueryWrapper.eq(Article::getStatus,SystemConstants.ARTICLE_STATUS_NORMAL);
        //isTop降序
        lambdaQueryWrapper.orderByDesc(Article::getIsTop);
        //分页查询
        Page<Article> page = new Page<>(pageNum,pageSize);
        page(page,lambdaQueryWrapper);
        //封装查询结果
        List<ArticleListVo> articleListVos = BeanCopyUtils.copyBeanList(page.getRecords(), ArticleListVo.class);
        PageVo pageVo = new PageVo(articleListVos,page.getTotal());

        return ResponseResult.okResult(pageVo);
    }
}
