package com.equipment.management.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.equipment.management.entity.TbScdDev;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 设备基本信息表 服务类
 * </p>
 *
 * @author ${author}
 * @since 2021-01-15
 */
public interface TbScdDevService extends IService<TbScdDev> {

    /**
     * 获取设备列表
     *
     * @param page
     * @param tbScdDev
     * @return
     */
    R getPageList(Page<TbScdDev> page,TbScdDev tbScdDev);
}
