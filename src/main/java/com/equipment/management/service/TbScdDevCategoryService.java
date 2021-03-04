package com.equipment.management.service;

import com.equipment.management.entity.TbScdDevCategory;
import com.baomidou.mybatisplus.extension.service.IService;
import com.equipment.management.entity.dto.TbScdDevCategoryDto;
import com.equipment.management.entity.vo.TbScdDevCategoryVO;

import java.util.List;

/**
 * <p>
 * 设备类别表 服务类
 * </p>
 *
 * @author ${author}
 * @since 2021-01-15
 */
public interface TbScdDevCategoryService extends IService<TbScdDevCategory> {

    /**
     * 获取所有分类列表
     * @return
     */
    List<TbScdDevCategoryVO> getCategoryList();

    /**
     * 获取指定id下的子级菜单
     * @param parentId
     * @return
     */
    List<TbScdDevCategoryVO> listByParentId(Integer parentId);
}
