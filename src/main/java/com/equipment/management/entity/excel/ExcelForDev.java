package com.equipment.management.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @program: equipment-management-system
 * @description:
 * @created: 2021/03/03 16:21
 */
@Data
public class ExcelForDev {
    /**
     * 设备编号
     */
    @ExcelProperty("设备编号")
    private String devNo;


    /**
     * 设备名称
     */
    @ExcelProperty("设备名称")
    private String devName;

    /**
     * 类别id
     */
    @ExcelProperty("类别id")
    private String cateId;

    /**
     * 型号
     */
    @ExcelProperty("型号")
    private String modelNo;

    /**
     * 规格
     */
    @ExcelProperty("规格")
    private String standard;

    @ExcelProperty("数量")
    private Integer devSum;

    /**
     * 单价
     */
    @ExcelProperty("单价")
    private BigDecimal price;

}
