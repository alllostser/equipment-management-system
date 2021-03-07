package com.equipment.management.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.equipment.management.entity.TbScdApplyItem;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 设备申请项表 服务类
 * </p>
 *
 * @author ${author}
 * @since 2021-01-15
 */
public interface TbScdApplyItemService extends IService<TbScdApplyItem> {

    /**
     * 统计单个设备被借出次数
     * @return
     */
    R getDevApplicatinNum();

    /**
     * 统计单个设备被借出数量
     * @return
     */
    R getDevApplicatinQuantity();
}
