package com.equipment.management.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.equipment.management.entity.TbScdDev;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 设备基本信息表 Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2021-01-15
 */
public interface TbScdDevMapper extends BaseMapper<TbScdDev> {

    IPage<TbScdDev> getPageList(Page<TbScdDev> page, @Param("tbScdDev") TbScdDev tbScdDev);
}
