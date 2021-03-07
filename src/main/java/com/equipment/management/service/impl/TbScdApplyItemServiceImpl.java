package com.equipment.management.service.impl;

import com.baomidou.mybatisplus.extension.api.R;
import com.equipment.management.entity.TbScdApplyItem;
import com.equipment.management.mapper.TbScdApplyItemMapper;
import com.equipment.management.service.TbScdApplyItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 设备申请项表 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2021-01-15
 */
@Service
public class TbScdApplyItemServiceImpl extends ServiceImpl<TbScdApplyItemMapper, TbScdApplyItem> implements TbScdApplyItemService {
    @Autowired
    private TbScdApplyItemMapper tbScdApplyItemMapper;

    /**
     * 统计单个设备被借出次数
     * @return
     */
    @Override
    public R getDevApplicatinNum() {
        List<Map<String, String>> echarts = tbScdApplyItemMapper.getDevApplicatinNum();
        return R.ok(echarts);
    }

    /**
     * 统计单个设备被借出数量
     * @return
     */
    @Override
    public R getDevApplicatinQuantity() {
        List<Map<String, String>> echarts = tbScdApplyItemMapper.getDevApplicatinQuantity();
        return R.ok(echarts);
    }
}
