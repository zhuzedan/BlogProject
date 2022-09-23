package com.zzd.domain.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author :zzd
 * @date : 2022/9/23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDetailVo extends ArticleListVo{
    //文章内容
    private String content;
}
