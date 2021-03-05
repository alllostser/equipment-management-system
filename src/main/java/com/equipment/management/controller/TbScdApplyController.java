package com.equipment.management.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.equipment.management.common.TableDataInfo;
import com.equipment.management.entity.TbScdApply;
import com.equipment.management.entity.TbScdApplyItem;
import com.equipment.management.entity.dto.TbScdApplyDto;
import com.equipment.management.entity.vo.TbscdApplyVO;
import com.equipment.management.exception.CommonException;
import com.equipment.management.service.TbScdApplyItemService;
import com.equipment.management.service.TbScdApplyService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 设备申请表 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2021-01-15
 */
@RestController
@RequestMapping("/apply")
public class TbScdApplyController {
    @Autowired
    private TbScdApplyService tbScdApplyService;
    @Autowired
    private TbScdApplyItemService tbScdApplyItemService;

    /**
     * 设备申请借用列表
     * @param page
     * @param tbScdApplyDto
     * @return
     */
    @GetMapping("/list")
    public TableDataInfo list(Page<TbScdApplyDto> page,TbScdApplyDto tbScdApplyDto){
        IPage<TbScdApplyDto> iPage = tbScdApplyService.listPage(page, tbScdApplyDto);
        return TableDataInfo.ResponseBySucess("成功", iPage.getTotal(), iPage.getRecords());
    }

    /**
     * 审核请求
     * @param tbscdApplyVO
     * @return
     */
    @PutMapping("/updateStatus")
    public R update(@RequestBody TbscdApplyVO tbscdApplyVO){
        int b = tbScdApplyService.updateStatusById(tbscdApplyVO);
        return R.ok(b);
    }

    @DeleteMapping("/delete/{ids}")
    @Transactional
    public R delete(@PathVariable String ids){
        List<String> asids = Arrays.asList(ids.split(","));
        boolean b = tbScdApplyService.removeByIds(asids);
        if (!b){
            throw new CommonException(500,"删除失败");
        }
        for (Serializable string : asids) {
            boolean remove = tbScdApplyItemService.remove(new LambdaQueryWrapper<TbScdApplyItem>().eq(TbScdApplyItem::getApplyId,string));
            if (!remove){
                throw new CommonException(500,"删除失败");
            }
        }
        return R.ok(b);
    }
}

