package com.equipment.management.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.equipment.management.entity.dto.TbScdDevCategoryDto;
import com.equipment.management.service.TbScdDevCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 设备类别表 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2021-01-15
 */
@RestController
@RequestMapping("/category")
public class TbScdDevCategoryController {
    @Autowired
    private TbScdDevCategoryService tbScdDevCategoryService;

    /**
     * 获取所有分类列表
     * @return
     */
    @GetMapping("/list")
    public R list(){
        List<TbScdDevCategoryDto> tbScdDevCategoryDtoList = tbScdDevCategoryService.getCategoryList();
        return R.ok(tbScdDevCategoryDtoList);
    }

    /**
     * 获取指定id下的子级菜单
     * @param id
     * @return
     */
    @GetMapping("/listById")
    public R listByParentId(Integer id){
        List<TbScdDevCategoryDto> tbScdDevCategoryDtoList = tbScdDevCategoryService.listByParentId(id);
        return R.ok(tbScdDevCategoryDtoList);
    }
}

