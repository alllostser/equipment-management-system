package com.equipment.management.controller;


import cn.hutool.core.util.ObjectUtil;
import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.equipment.management.common.TableDataInfo;
import com.equipment.management.entity.TbScdDev;
import com.equipment.management.entity.excel.ExcelForDev;
import com.equipment.management.entity.vo.TbScdDevVO;
import com.equipment.management.entity.vo.TbscdApplyVO;
import com.equipment.management.listener.ExcelListener;
import com.equipment.management.service.TbScdDevService;
import com.equipment.management.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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
        String[] split = cateIds.split(",");
        String substring = split[split.length-1];
        System.out.println(substring);
        TbScdDev tbScdDev = new TbScdDev();
        tbScdDev.setDevSum(tbScdDevVO.getDevSum());
        tbScdDev.setDevNo(tbScdDevVO.getDevNo());
        tbScdDev.setCateId(Integer.parseInt(substring));
        tbScdDev.setDevName(tbScdDevVO.getDevName());
        tbScdDev.setModelNo(tbScdDevVO.getModelNo());
        tbScdDev.setPrice(tbScdDevVO.getPrice());
        tbScdDev.setStandard(tbScdDevVO.getStandard());
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
        List<String> asids = Arrays.asList(ids.split(","));
        boolean b = tbScdDevService.deleteByIds(asids);
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
    public R devApplication(@RequestBody TbscdApplyVO tbscdApplyVO){
        R response = tbScdDevService.devApplication(tbscdApplyVO);
        return response;
    }

    //导出为Excel
    @RequestMapping("/downloadexcel")
    public void getExcel(HttpServletResponse response) throws IllegalAccessException, IOException,
            InstantiationException {
        List<ExcelForDev> list = tbScdDevService.list2();
        ExcelUtil.download(response,ExcelForDev.class,list);
    }
    //导入Excel
    @RequestMapping("/importexcel")
    public R importexcel(@RequestParam(value = "excelFile") MultipartFile file) throws IOException{
        EasyExcel.read(file.getInputStream(), ExcelForDev.class, new ExcelListener(tbScdDevService)).sheet().doRead();
        return R.ok("导入成功");
    }
}

