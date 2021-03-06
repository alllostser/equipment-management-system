package com.equipment.management.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author ${author}
 * @since 2021-01-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TbScdUser implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * 用户id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    @TableField("user_name")
    private String username;

    /**
     * 用户密码
     */
    @TableField("user_pwd")
    private String password;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 性别
     */
    private Integer userSex;

    /**
     * 角色
     */
    private Integer userRole;

    /**
     * 电话
     */
    private String userTel;

    /**
     * 菜单列表
     */
    private String userMenu;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime modifyTime;

    /**
     * 创建人
     */
    private Long createEmp;

    /**
     * 修改人
     */
    private Long modifyEmp;

    /**
     * 是否有效 1：有效 0：无效
     */
    private Boolean isValid;

    /**
     * 备注
     */
    private String remark;

    private List<TbScdRole> roles;
}
