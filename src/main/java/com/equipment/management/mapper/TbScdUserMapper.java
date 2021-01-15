package com.equipment.management.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.equipment.management.entity.TbScdUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2021-01-15
 */
public interface TbScdUserMapper extends BaseMapper<TbScdUser> {

    /**
     * 获取用户列表+模糊查询
     * @param page
     * @param user
     * @return
     */
    IPage<TbScdUser> listPage(@Param("page") Page page, @Param("user") TbScdUser user);
}