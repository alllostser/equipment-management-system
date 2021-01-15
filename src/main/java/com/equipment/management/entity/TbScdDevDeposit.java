package com.equipment.management.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 设备存放地表
 * </p>
 *
 * @author ${author}
 * @since 2021-01-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TbScdDevDeposit implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 设备存放地编号
     */
    private String devDepositNo;

    /**
     * 设备存放地名称
     */
    private String devDepositName;

    private LocalDateTime createTime;

    private LocalDateTime modifyTime;

    private Long createEmp;

    private Long modifyEmp;

    private Integer isValid;


}
