package com.zzd.controller;

import com.zzd.domain.entity.Article;
import com.zzd.domain.ResponseResult;
import com.zzd.service.ArticleService;
import com.zzd.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @GetMapping("/list")
    public List<Article> test() {
        return articleService.list();
    }

    @GetMapping("/hotArticleList")
    public ResponseResult hotArticleResult() {
        //查询热门文章
        ResponseResult result =  articleService.hotArticleList();
        return result;
    }
    @GetMapping("/articleList")
    public ResponseResult articleList(Integer pageNum,Integer pageSize,Long categoryId) {
        return articleService.articleList(pageNum,pageSize, categoryId);
    }

}
