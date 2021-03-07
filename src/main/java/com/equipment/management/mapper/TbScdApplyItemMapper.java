package com.equipment.management.mapper;

import com.equipment.management.entity.TbScdApplyItem;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 设备申请项表 Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2021-01-15
 */
public interface TbScdApplyItemMapper extends BaseMapper<TbScdApplyItem> {

    /**
     * 统计单个设备被借出次数
     * @return
     */
    List<Map<String, String>> getDevApplicatinNum();

    /**
     * 统计单个设备被借出数量
     * @return
     */
    List<Map<String, String>> getDevApplicatinQuantity();
}
