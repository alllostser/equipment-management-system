package com.equipment.management.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.equipment.management.entity.TbScdUser;
import com.equipment.management.service.TbScdUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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
}

