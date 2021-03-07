package com.equipment.management.controller;

import com.baomidou.mybatisplus.extension.api.R;
import com.equipment.management.service.TbScdApplyItemService;
import com.equipment.management.service.TbScdApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TbscdStatisticsController
 * @Description //TODO
 * @Date 2021/3/7 18:15
 * @Version 1.0
 **/
@RestController
@RequestMapping("/statistics")
public class TbscdStatisticsController {
    @Autowired
    private TbScdApplyItemService tbScdApplyItemService;

    /**
     * 统计单个设备被借出次数
     * @return
     */
    @GetMapping("/getDevApplicationNum")
    public R getDevApplicatinNum(){
        R response = tbScdApplyItemService.getDevApplicatinNum();
        return response;
    }

    /**
     * 统计单个设备被借出数量
     * @return
     */
    @GetMapping("/getDevApplicationQuantity")
    public R getDevApplicatinQuantity(){
        R response = tbScdApplyItemService.getDevApplicatinQuantity();
        return response;
    }
}
