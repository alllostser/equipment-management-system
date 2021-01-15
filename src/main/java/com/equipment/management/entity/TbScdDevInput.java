package com.equipment.management.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 设备入库记录表
 * </p>
 *
 * @author ${author}
 * @since 2021-01-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TbScdDevInput implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 入库编号
     */
    private String inputNo;

    /**
     * 条形码
     */
    private String barCode;

    /**
     * 设备名称
     */
    private String devName;

    /**
     * 类别id
     */
    private Integer cateId;

    /**
     * 型号
     */
    private String modelNo;

    /**
     * 规格
     */
    private String standard;

    /**
     * 单价
     */
    private BigDecimal price;

    /**
     * 国家id
     */
    private Integer countryId;

    /**
     * 生产厂家
     */
    private String firm;

    /**
     * 出厂日期
     */
    private String outFirmNo;

    /**
     * 购买时间
     */
    private LocalDateTime purchaseTime;

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
    private Integer devNum;

    /**
     * 经手人
     */
    private Long dealEmp;

    /**
     * 备注
     */
    private String remark;

    private LocalDateTime createTime;

    private LocalDateTime modifyTime;

    private Long createEmp;

    private Long modifyEmp;

    private Integer isValid;


}
