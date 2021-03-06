package com.equipment.management.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.equipment.management.entity.TbScdRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2021-03-04
 */
public interface TbScdRoleMapper extends BaseMapper<TbScdRole> {

    IPage<TbScdRole> listPage(Page<TbScdRole> page, @Param("role") TbScdRole tbScdRole);

    @Select("select r.id,r.role,r.role_name roleName,r.status ,r.description from tb_scd_user u , tb_scd_role r  where u.user_role=r.id and u.id=#{uid};")
    List<TbScdRole> findByUid(Integer uid);

}
