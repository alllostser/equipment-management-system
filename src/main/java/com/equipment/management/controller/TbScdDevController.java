package com.equipment.management.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.equipment.management.common.TableDataInfo;
import com.equipment.management.entity.TbScdDev;
import com.equipment.management.entity.vo.TbScdDevVO;
import com.equipment.management.entity.vo.TbscdApplyVO;
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
    public TableDataInfo list(Page<TbScdDev> page, TbScdDev tbScdDev){
        TableDataInfo response = tbScdDevService.getPageList(page,tbScdDev);
        return response;
    }

    /**
     * 添加设备
     * @param tbScdDevVO
     * @return
     */
    @PostMapping("/add")
    public R addDev(@RequestBody TbScdDevVO tbScdDevVO){
        String cateIds = tbScdDevVO.getCateId();
        String substring = cateIds.substring(cateIds.length() - 2, cateIds.length()-1);
        System.out.println(substring);
        TbScdDev tbScdDev = new TbScdDev();
        tbScdDev.setDevSum(tbScdDevVO.getDevSum());
        tbScdDev.setDevNo(tbScdDevVO.getDevNo());
        tbScdDev.setCateId(Integer.parseInt(substring));
        tbScdDev.setDevName(tbScdDevVO.getDevName());
        tbScdDev.setModelNo(tbScdDevVO.getModelNo());
        tbScdDev.setPrice(tbScdDevVO.getPrice());
        tbScdDev.setStandard(tbScdDevVO.getStandard());
//
        boolean save = tbScdDevService.save(tbScdDev);
        return R.ok(substring);
    }

    /**
     * 根据id批量删除
     * @param ids
     * @return
     */
    @DeleteMapping("/delete")
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

    /**
     * 设备申请
     * @param tbscdApplyVO
     * @return
     */
    @PostMapping("/application")
    public R devApplication(TbscdApplyVO tbscdApplyVO){
        R response = tbScdDevService.devApplication(tbscdApplyVO);
        return response;
    }
}

