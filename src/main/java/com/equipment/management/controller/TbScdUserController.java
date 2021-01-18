package com.equipment.management.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.equipment.management.entity.TbScdUser;
import com.equipment.management.service.TbScdUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2021-01-15
 */
@RestController
@RequestMapping("/user")
public class TbScdUserController {
    @Autowired
    private TbScdUserService tbScdUserService;

    /**
     * 获取用户列表+模糊查询
     * @param page
     * @param user
     * @return
     */
    @GetMapping("/list")
    public R list(Page page, TbScdUser user){
       IPage userPage =  tbScdUserService.listPage(page,user);
       return R.ok(userPage);
    }

    /**
     * 更新用户
     * @param tbScdUser
     * @return
     */
    @PostMapping("/update")
    public R update(TbScdUser tbScdUser){
        if (ObjectUtils.isEmpty(tbScdUser.getId())){
            return R.failed("id不能为空");
        }
        boolean update = tbScdUserService.updateById(tbScdUser);
        if (!update){
            return R.failed("更新失败");
        }
        return R.ok(update);
    }

    /**
     * 添加用户
     * @param tbScdUser
     * @return
     */
    @PostMapping("/insert")
    public R insert(TbScdUser tbScdUser){
        boolean save = tbScdUserService.save(tbScdUser);
        if (!save){
            return R.failed("添加失败");
        }
        return R.ok(save);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @DeleteMapping("/delete")
    public R deleteByIds(String ids){
        List<String> asids = Arrays.asList(ids.split(","));
         int delete = tbScdUserService.deleteByIds(asids);
         return R.ok(delete);
    }

}

