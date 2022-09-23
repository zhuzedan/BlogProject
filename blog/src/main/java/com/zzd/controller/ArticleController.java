package com.zzd.controller;

import com.zzd.entity.Article;
import com.zzd.entity.ResponseResult;
import com.zzd.service.ArticleService;
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

}
