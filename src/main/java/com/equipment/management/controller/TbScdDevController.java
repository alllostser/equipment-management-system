package com.equipment.management.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.equipment.management.entity.TbScdDev;
import com.equipment.management.service.TbScdDevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * <p>
 * 设备基本信息表 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2021-01-15
 */
@RestController
@RequestMapping("/dev")
public class TbScdDevController {
    @Autowired
    private TbScdDevService tbScdDevService;

    /**
     * 获取设备列表
     * @param tbScdDev
     * @return
     */
    @GetMapping("/list")
    public R list(Page<TbScdDev> page, TbScdDev tbScdDev){
        R response = tbScdDevService.getPageList(page,tbScdDev);
        return response;
    }

    /**
     * 添加设备
     * @param tbScdDev
     * @return
     */
    @PostMapping("/add")
    public R addDev(TbScdDev tbScdDev){
        boolean save = tbScdDevService.save(tbScdDev);
        return R.ok(save);
    }

    /**
     * 根据id批量删除
     * @param ids
     * @return
     */
    public R delDev(String ids){
        boolean b = tbScdDevService.removeByIds(Arrays.asList(ids));
        return R.ok(b);
    }

    /**
     * 修改设备信息
     * @param tbScdDev
     * @return
     */
    @PostMapping("/update")
    public R updateDev(@RequestBody TbScdDev tbScdDev){
        boolean b = tbScdDevService.updateById(tbScdDev);
        return R.ok(b);
    }
//
//    public R devApplication(){
//    }
}

