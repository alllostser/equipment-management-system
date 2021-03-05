package com.equipment.management.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.equipment.management.entity.TbScdRole;
import com.equipment.management.mapper.TbScdRoleMapper;
import com.equipment.management.service.TbScdRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2021-03-04
 */
@Service
public class TbScdRoleServiceImpl extends ServiceImpl<TbScdRoleMapper, TbScdRole> implements TbScdRoleService {
    @Autowired
    private TbScdRoleMapper tbScdRoleMapper;
    /**
     * 角色列表
     * @param page
     * @param tbScdRole
     * @return
     */
    @Override
    public IPage<TbScdRole> listPage(Page<TbScdRole> page, TbScdRole tbScdRole) {
        IPage<TbScdRole> iPage = tbScdRoleMapper.listPage(page, tbScdRole);
        return iPage;
    }
}
