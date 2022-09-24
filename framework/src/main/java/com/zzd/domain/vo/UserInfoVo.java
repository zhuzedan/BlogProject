package com.zzd.domain.vo;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author :zzd
 * @date : 2022/9/24
 */
@Data
@Accessors(chain = true)
public class UserInfoVo {
    /**
     * 主键
     */
    private Long id;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 头像
     */
    private String avatar;

    private String sex;

    private String email;

}
