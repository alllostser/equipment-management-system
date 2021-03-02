package com.equipment.management.entity.vo;

import com.equipment.management.entity.TbScdApply;
import lombok.Data;

/**
 * @program: equipment-management-system
 * @description:
 * @created: 2021/02/26 15:15
 */
@Data
public class TbscdApplyVO extends TbScdApply {
    private Long devId;

    /**
     * 数量
     */
    private Integer devNum;
}
