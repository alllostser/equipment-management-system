package com.equipment.management.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.equipment.management.entity.TbScdRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2021-03-04
 */
public interface TbScdRoleMapper extends BaseMapper<TbScdRole> {

    IPage<TbScdRole> listPage(Page<TbScdRole> page, @Param("role") TbScdRole tbScdRole);
}
