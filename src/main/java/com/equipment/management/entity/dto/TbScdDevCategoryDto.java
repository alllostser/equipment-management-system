package com.equipment.management.entity.dto;

import com.equipment.management.entity.TbScdDevCategory;
import lombok.Data;

import java.util.List;

/**
 * @program: equipment-management-system
 * @description: 分类列表dto
 * @created: 2021/01/18 15:39
 */
@Data
public class TbScdDevCategoryDto extends TbScdDevCategory {
    /**
     * 分类子类
     */
    private List<TbScdDevCategoryDto> childCategory;
}
