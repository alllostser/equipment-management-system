package com.equipment.management.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.equipment.management.entity.TbScdDevCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.equipment.management.entity.dto.TbScdDevCategoryDto;

import java.util.List;

/**
 * <p>
 * 设备类别表 Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2021-01-15
 */
public interface TbScdDevCategoryMapper extends BaseMapper<TbScdDevCategory> {

    /**
     * 获取分类下所有子类
     * @param parentId
     * @return
     */
    List<TbScdDevCategoryDto> selectList2(Integer parentId);
}
