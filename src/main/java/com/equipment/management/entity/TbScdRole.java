package com.equipment.management.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2021-03-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TbScdRole implements GrantedAuthority,Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色名
     */
    private String role;

    /**
     * 角色
     */
    private String roleName;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 描述
     */
    private String description;


    @Override
    public String getAuthority() {
        return roleName;
    }
}
