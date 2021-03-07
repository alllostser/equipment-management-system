package com.equipment.management.entity.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @program: equipment-management-system
 * @description:
 * @created: 2021/03/04 15:44
 */
@Data
public class TbScdApplyDto {
    private Long id;
    private String applyNo;
    private String realName;
    private Integer devNum;
    private String devNo;
    private Integer userRole;
    /**
     * 规格
     */
    private String standard;
    private String devName;
    private Long devId;
    /**
     * 申请状态 0待审核 ， 1教师已通过，2管理员已通过，3未通过，4已归还，5已撤回
     */
    private Integer status;

    /**
     * 审核人
     */
    private Long dealEmp;

    private String dealName;

    /**
     * 备注
     */
    private String remark;

    /**
     * 申请时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime applyTime;

    /**
     * 审核时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime dealTime;

    /**
     * 处理意见
     */
    private String dealText;

    /**
     * 申请理由
     */
    private String applyText;

    private Integer isValid;
}
