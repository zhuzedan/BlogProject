package com.zzd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzd.domain.ResponseResult;
import com.zzd.domain.entity.Comment;


/**
 * 评论表(Comment)表服务接口
 *
 * @author zzd
 * @since 2022-09-24 12:46:18
 */
public interface CommentService extends IService<Comment> {

    ResponseResult commentList(Long articleId, Integer pageNum, Integer pageSize);

    ResponseResult addComment(Comment comment);
}