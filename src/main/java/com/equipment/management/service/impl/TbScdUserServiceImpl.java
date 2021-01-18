package com.equipment.management.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.equipment.management.entity.TbScdUser;
import com.equipment.management.mapper.TbScdUserMapper;
import com.equipment.management.service.TbScdUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2021-01-15
 */
@Service
@AllArgsConstructor
public class TbScdUserServiceImpl extends ServiceImpl<TbScdUserMapper, TbScdUser> implements TbScdUserService {
    private final TbScdUserMapper tbScdUserMapper;
    /**
     * 获取用户列表+模糊查询
     * @param page
     * @param user
     * @return
     */
    @Override
    public IPage<TbScdUser> listPage(Page page, TbScdUser user) {
        return tbScdUserMapper.listPage(page,user);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @Override
    public int deleteByIds(List<String> ids) {
        return tbScdUserMapper.deleteBatchIds(ids);
    }
}
