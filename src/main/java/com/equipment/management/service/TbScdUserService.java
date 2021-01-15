package com.equipment.management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.equipment.management.entity.TbScdUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author ${author}
 * @since 2021-01-15
 */
public interface TbScdUserService extends IService<TbScdUser> {

    /**
     * 获取用户列表+模糊查询
     * @param page
     * @param user
     * @return
     */
    IPage listPage(Page page, TbScdUser user);
}
