package com.equipment.management.controller;


import cn.hutool.json.JSONObject;
import com.equipment.management.entity.TbScdMenu;
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
    @GetMapping("/getMenu")
    public List<TbScdMenu> getMenu(){
        List<TbScdMenu> menu = new ArrayList<>();
        TbScdMenu tbScdMenu= new TbScdMenu();
            tbScdMenu.setId(1);
            tbScdMenu.setTitle("工作空间");
            tbScdMenu.setType(0);
            tbScdMenu.setIcon("layui-icon layui-icon-console");
            List<TbScdMenu> scdMenus = new ArrayList<>();
           TbScdMenu scdMenu = new TbScdMenu();
                scdMenu.setId(10);
                scdMenu.setTitle("控制后台");
                scdMenu.setIcon("layui-icon layui-icon-console");
                scdMenu.setType(1);
                scdMenu.setOpenType("_iframe");
                scdMenu.setHref("view/console/console1.html");
                scdMenus.add(scdMenu);
            tbScdMenu.setChildren(scdMenus);
            menu.add(tbScdMenu);
        return menu;
    }
}

