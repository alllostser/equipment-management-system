package com.equipment.management.entity.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @program: equipment-management-system
 * @description:
 * @created: 2021/03/03 16:21
 */
@Data
public class TbScdDevVO {
    private Long id;

    /**
     * 设备编号
     */
    private String devNo;


    /**
     * 设备名称
     */
    private String devName;

    /**
     * 类别id
     */
    private String cateId;

    /**
     * 型号
     */
    private String modelNo;

    /**
     * 规格
     */
    private String standard;

    private Integer devSum;

    /**
     * 单价
     */
    private BigDecimal price;

}
