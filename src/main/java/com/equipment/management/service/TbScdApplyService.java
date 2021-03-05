package com.equipment.management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.equipment.management.entity.TbScdApply;
import com.baomidou.mybatisplus.extension.service.IService;
import com.equipment.management.entity.dto.TbScdApplyDto;
import com.equipment.management.entity.vo.TbscdApplyVO;

/**
 * <p>
 * 设备申请表 服务类
 * </p>
 *
 * @author ${author}
 * @since 2021-01-15
 */
public interface TbScdApplyService extends IService<TbScdApply> {

    /**
     * 设备申请借用列表
     * @param page
     * @param tbScdApplyDto
     * @return
     */
    IPage<TbScdApplyDto> listPage(Page<TbScdApplyDto> page, TbScdApplyDto tbScdApplyDto);

    /**
     * 审核请求
     * @param tbScdApplyVO
     * @return
     */
    int updateStatusById(TbscdApplyVO tbScdApplyVO);
}
