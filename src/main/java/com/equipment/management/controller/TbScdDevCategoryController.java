package com.equipment.management.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.equipment.management.common.CategoryTableInfo;
import com.equipment.management.common.Status;
import com.equipment.management.common.TableDataInfo;
import com.equipment.management.entity.TbScdDevCategory;
import com.equipment.management.entity.TbScdUser;
import com.equipment.management.entity.dto.TbScdDevCategoryDto;
import com.equipment.management.entity.vo.TbScdDevCategoryVO;
import com.equipment.management.service.TbScdDevCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
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
    public CategoryTableInfo list(){
        List<TbScdDevCategoryVO> tbScdDevCategoryDtoList = tbScdDevCategoryService.getCategoryList();
        return CategoryTableInfo.ResponseBySucess(new Status(200,"操作成功"),tbScdDevCategoryDtoList);
    }

    /**
     * 管理员获取所有分类列表
     * @return
     */
    @GetMapping("/list2")
    public TableDataInfo list2(){
        List<TbScdDevCategory> tbScdDevCategoryDtoList = tbScdDevCategoryService.list();
        return TableDataInfo.ResponseBySucess("成功",null,tbScdDevCategoryDtoList);
    }
    @GetMapping("/list3")
    public List<TbScdDevCategoryVO> list3(){
        List<TbScdDevCategoryVO> tbScdDevCategoryDtoList = tbScdDevCategoryService.getCategoryList();
        return tbScdDevCategoryDtoList;
    }

    /**
     * 修改状态
     * @param Id
     * @return
     */
    @GetMapping("/updateIsValid/{Id}")
    public R updateIsValid(@PathVariable Long Id){
        TbScdDevCategory byId = tbScdDevCategoryService.getById(Id);
        if (byId.getIsValid()==0){
            byId.setIsValid(1);
        }else {
            byId.setIsValid(0);
        }
        boolean b = tbScdDevCategoryService.updateById(byId);
        if (!b){
            return R.failed("修改失败");
        }
        return R.ok("修改成功");
    }
    /**
     * 获取指定id下的子级菜单
     * @param id
     * @return
     */
    @GetMapping("/listById")
    public R listByParentId(Integer id){
        List<TbScdDevCategoryVO> tbScdDevCategoryDtoList = tbScdDevCategoryService.listByParentId(id);
        return R.ok(tbScdDevCategoryDtoList);
    }

    /**
     * 添加分类
     * @param tbScdDevCategory
     * @return
     */
    @PostMapping("/add")
    public R addCategory(@RequestBody TbScdDevCategory tbScdDevCategory){
        tbScdDevCategory.setCreateTime(LocalDateTime.now());
        if (ObjectUtils.isEmpty(tbScdDevCategory.getParentId())){
            tbScdDevCategory.setParentId(0);
        }
        boolean save = tbScdDevCategoryService.save(tbScdDevCategory);
        return R.ok(save);
    }

    /**
     * 修改分类
     * @param tbScdDevCategory
     * @return
     */
    @PostMapping("/update")
    public R updateCateory(@RequestBody TbScdDevCategory tbScdDevCategory){

        boolean b = tbScdDevCategoryService.updateById(tbScdDevCategory);
        return R.ok(b);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @DeleteMapping("/delete/{ids}")
    public R deleteById(@PathVariable String ids){
        boolean b = tbScdDevCategoryService.removeByIds(Arrays.asList(ids.split(",")));
        return R.ok(b);
    }
}
