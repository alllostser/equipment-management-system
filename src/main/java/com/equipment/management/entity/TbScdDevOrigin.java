package com.equipment.management.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 设备来源表
 * </p>
 *
 * @author ${author}
 * @since 2021-01-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TbScdDevOrigin implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 设备来源编号
     */
    private String devOriginNo;

    /**
     * 设备来源名称
     */
    private String devOriginName;

    private LocalDateTime createTime;

    private LocalDateTime modifyTime;

    private Long createEmp;

    private Long modifyEmp;

    private Integer isValid;


}
