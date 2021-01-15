package com.equipment.management.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 设备维修记录表
 * </p>
 *
 * @author ${author}
 * @since 2021-01-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TbScdMaintain implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 维修记录编号
     */
    private String maintainNo;

    /**
     * 设备Id
     */
    private Long devId;

    /**
     * 设备数量
     */
    private Integer maintainNum;

    /**
     * 维修负责人
     */
    private String maintainEmp;

    /**
     * 维修状态
     */
    private Integer status;

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
