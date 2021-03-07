package com.equipment.management.mapper;

import com.equipment.management.entity.TbScdMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 系统菜单表 Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2021-01-15
 */
public interface TbScdMenuMapper extends BaseMapper<TbScdMenu> {

    List<TbScdMenu> selectList2(Integer id);
}
