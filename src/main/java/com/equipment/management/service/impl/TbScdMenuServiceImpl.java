package com.equipment.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.equipment.management.entity.TbScdMenu;
import com.equipment.management.entity.security.MyUserDetails;
import com.equipment.management.entity.vo.TbScdDevCategoryVO;
import com.equipment.management.mapper.TbScdMenuMapper;
import com.equipment.management.service.TbScdMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 系统菜单表 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2021-01-15
 */
@Service
public class TbScdMenuServiceImpl extends ServiceImpl<TbScdMenuMapper, TbScdMenu> implements TbScdMenuService {
    @Autowired
    private TbScdMenuService tbScdMenuService;

    @Override
    public List<TbScdMenu> getMenu() {
        MyUserDetails principal = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Integer userRole = principal.getUserRole();
        List<TbScdMenu> list = tbScdMenuService.list(new LambdaQueryWrapper<TbScdMenu>().eq(TbScdMenu::getParentId, 0).last("and FIND_IN_SET(\""+userRole+"\", role_id) ;"));
        List<TbScdMenu> list2 = getMenuList(list);
        return list2;
    }

    private List<TbScdMenu> getMenuList(List<TbScdMenu> list) {
        for (TbScdMenu dto : list) {
            //获取该分类下所有子类
            List<TbScdMenu> tbScd = baseMapper.selectList2(dto.getId());
            //递归获取子类的子类
            List<TbScdMenu> categoryList2 = getMenuList(tbScd);
            dto.setChildren(categoryList2);
        }
        return list;
    }
}
