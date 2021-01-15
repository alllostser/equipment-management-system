package com.equipment.management.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 系统菜单表
 * </p>
 *
 * @author ${author}
 * @since 2021-01-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TbScdMenu implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 菜单名称
     */
    private String menuName;

    /**
     * 菜单地址
     */
    private String menuUrl;

    /**
     * 上级菜单id
     */
    private Integer parentId;

    private LocalDateTime createTime;

    private LocalDateTime modifyTime;

    private Long createEmp;

    private Long modifyEmp;

    private Integer isValid;


}
