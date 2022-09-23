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
public class ArticleListVo {
    @TableId
    private Long id;
    //标题
    private String title;
    //文章摘要
    private String summary;
    //所属分类id
    private Long categoryId;
    //所属分类名
    private String categoryName;
    //缩略图
    private String thumbnail;

    private Long createBy;

    private Date createTime;
}
