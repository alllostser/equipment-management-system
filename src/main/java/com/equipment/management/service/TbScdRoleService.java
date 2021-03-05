package com.equipment.management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.equipment.management.entity.TbScdRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ${author}
 * @since 2021-03-04
 */
public interface TbScdRoleService extends IService<TbScdRole> {
    /**
     * 角色列表
     * @param page
     * @param tbScdRole
     * @return
     */
    IPage<TbScdRole> listPage(Page<TbScdRole> page, TbScdRole tbScdRole);
}
