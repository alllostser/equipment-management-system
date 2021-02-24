package com.equipment.management.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.equipment.management.entity.TbScdDev;
import com.equipment.management.mapper.TbScdDevMapper;
import com.equipment.management.service.TbScdDevService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 设备基本信息表 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2021-01-15
 */
@Service
public class TbScdDevServiceImpl extends ServiceImpl<TbScdDevMapper, TbScdDev> implements TbScdDevService {
    @Autowired
    private TbScdDevMapper tbScdDevMapper;

    /**
     * 获取设备列表
     *
     * @param page
     * @param tbScdDev
     * @return
     */
    @Override
    public R getPageList(Page<TbScdDev> page, TbScdDev tbScdDev) {
        IPage iPage = tbScdDevMapper.getPageList(page,tbScdDev);
        return R.ok(iPage);
    }
}
