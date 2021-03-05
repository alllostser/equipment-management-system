package com.equipment.management.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.equipment.management.common.TableDataInfo;
import com.equipment.management.entity.TbScdDev;
import com.baomidou.mybatisplus.extension.service.IService;
import com.equipment.management.entity.excel.ExcelForDev;
import com.equipment.management.entity.vo.TbscdApplyVO;

import java.io.Serializable;
import java.util.List;

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
    TableDataInfo getPageList(Page<TbScdDev> page, TbScdDev tbScdDev);

    /**
     * 设备申请
     * @param tbscdApplyVO
     * @return
     */
    R devApplication(TbscdApplyVO tbscdApplyVO);

    boolean deleteByIds(List<String> asList);

    List<ExcelForDev> list2();

    void saveList(List<ExcelForDev> list);
}
