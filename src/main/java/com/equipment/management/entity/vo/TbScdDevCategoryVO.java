package com.equipment.management.entity.vo;

import lombok.Data;

import java.util.List;

/**
 * @program: equipment-management-system
 * @description:
 * @created: 2021/03/03 14:04
 */
@Data
public class TbScdDevCategoryVO {
    private Integer id;
    private String title;
    private Boolean last;
    private Integer parentId;
    private Integer isValid;
    private List<TbScdDevCategoryVO> children;
}
