package com.equipment.management.entity;

import java.math.BigDecimal;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 设备基本信息表
 * </p>
 *
 * @author ${author}
 * @since 2021-01-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TbScdDev implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 设备编号
     */
    @ExcelProperty("设备编号")
    private String devNo;

    /**
     * 条形码
     */
    private String barCode;

    /**
     * 设备名称
     */
    @ExcelProperty("设备名称")
    private String devName;

    /**
     * 类别id
     */
    @ExcelProperty("类别id")
    private Integer cateId;

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

    /**
     * 单价
     */
    @ExcelProperty("单价")
    private BigDecimal price;

    /**
     * 国家id
     */
    private Integer countryId;

    /**
     * 生产厂商
     */
    private String firm;

    /**
     * 生产日期
     */
    private String outFirmNo;

    /**
     * 购置时间
     */
//    private LocalDateTime purchaseTime;

    /**
     * 经费科目
     */
    private Integer foundId;

    /**
     * 设备来源
     */
    private Integer originId;

    /**
     * 存放地
     */
    private Integer depositId;

    /**
     * 设备数量
     */
    @ExcelProperty("设备数量")
    private Integer devSum;

    /**
     * 备注
     */
    private String remark;

//    private LocalDateTime createTime;
//
//    private LocalDateTime modifyTime;

    private Long createEmp;

    private Long modifyEmp;

    private Integer isValid;

    /**
     * 设备权限
     */
    private Integer devPower;

    /**
     * 设备使用方向
     */
    private Integer direcId;


}
