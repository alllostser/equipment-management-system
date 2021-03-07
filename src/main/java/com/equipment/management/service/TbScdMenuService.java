package com.equipment.management.service;

import com.equipment.management.entity.TbScdMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 系统菜单表 服务类
 * </p>
 *
 * @author ${author}
 * @since 2021-01-15
 */
public interface TbScdMenuService extends IService<TbScdMenu> {

    /**
     * 获取菜单
     * @return
     */
    List<TbScdMenu> getMenu();
}
