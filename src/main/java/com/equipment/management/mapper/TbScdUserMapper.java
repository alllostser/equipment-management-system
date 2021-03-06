package com.equipment.management.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.equipment.management.entity.TbScdUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.equipment.management.entity.security.MyUserDetails;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2021-01-15
 */
public interface TbScdUserMapper extends BaseMapper<TbScdUser> {

    /**
     * 获取用户列表+模糊查询
     * @param page
     * @param user
     * @return
     */
    IPage<TbScdUser> listPage(@Param("page") Page page, @Param("user") TbScdUser user);

    @Select(" select id, user_name username, user_pwd password, real_name realName, user_sex userSex, user_role userRole, user_tel userTel, user_menu userMenu, create_time createTime, modify_time modifyTime, create_emp createEmp, modify_emp modifyEmp, is_valid isValid, remark from tb_scd_user where user_name = #{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roles", column = "id", javaType = List.class,
                    many = @Many(select = "com.equipment.management.mapper.TbScdRoleMapper.findByUid")
            )
    })
    MyUserDetails findByName(String username);
}
