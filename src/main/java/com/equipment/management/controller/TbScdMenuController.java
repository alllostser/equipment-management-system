package com.equipment.management.controller;


import cn.hutool.json.JSONObject;
import com.equipment.management.entity.TbScdMenu;
import com.equipment.management.service.TbScdMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 系统菜单表 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2021-01-15
 */
@RestController
@RequestMapping("/menu")
public class TbScdMenuController {
    @Autowired
    private TbScdMenuService tbScdMenuService;

    /**
     * 获取菜单
     * @return
     */
    @GetMapping("/getMenu")
    public List<TbScdMenu> getMenu(){
        List<TbScdMenu> menu = tbScdMenuService.getMenu();
        return menu;
    }
}

