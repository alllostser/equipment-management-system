package com.equipment.management.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.equipment.management.entity.TbScdApply;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.equipment.management.entity.dto.TbScdApplyDto;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 设备申请表 Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2021-01-15
 */
public interface TbScdApplyMapper extends BaseMapper<TbScdApply> {

    IPage<TbScdApplyDto> listPage(Page<TbScdApplyDto> page, @Param("applyDto") TbScdApplyDto tbScdApplyDto);

    /**
     * 审核请求
     * @param tbScdApply
     * @return
     */
    int updateStatusById(TbScdApply tbScdApply);
}
