package com.zzd.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzd.domain.entity.Menu;

import java.util.List;


/**
 * 菜单权限表(Menu)表服务接口
 *
 * @author zzd
 * @since 2022-09-27 15:21:25
 */
public interface MenuService extends IService<Menu> {

    List<String> selectPermsByUserId(Long id);
}

