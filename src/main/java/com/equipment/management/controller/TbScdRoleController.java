package com.equipment.management.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.equipment.management.common.TableDataInfo;
import com.equipment.management.entity.TbScdRole;
import com.equipment.management.entity.TbScdUser;
import com.equipment.management.service.TbScdRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2021-03-04
 */
@RestController
@RequestMapping("/role")
public class TbScdRoleController {
    @Autowired
    private TbScdRoleService tbScdRoleService;

    /**
     * 角色列表
     * @param page
     * @param tbScdRole
     * @return
     */
    @GetMapping("list")
    public TableDataInfo list(Page<TbScdRole> page,TbScdRole tbScdRole){
        IPage<TbScdRole> iPage = tbScdRoleService.listPage(page,tbScdRole);
        return TableDataInfo.ResponseBySucess("成功", iPage.getTotal(), iPage.getRecords());
    }

    @GetMapping("/updateStatus/{id}")
    public R updateStatus(@PathVariable Integer id){
        TbScdRole byId = tbScdRoleService.getById(id);
        if (byId.getStatus()==0){
            byId.setStatus(1);
        }else {
            byId.setStatus(0);
        }
        boolean b = tbScdRoleService.updateById(byId);
        if (!b){
            return R.failed("修改失败");
        }
        return R.ok("修改成功");
    }
}

