package com.equipment.management.service.impl;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.equipment.management.entity.TbScdApplyItem;
import com.equipment.management.entity.TbScdDev;
import com.equipment.management.entity.vo.TbscdApplyVO;
import com.equipment.management.exception.CommonException;
import com.equipment.management.mapper.TbScdDevMapper;
import com.equipment.management.service.TbScdApplyItemService;
import com.equipment.management.service.TbScdApplyService;
import com.equipment.management.service.TbScdDevService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * <p>
 * 设备基本信息表 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2021-01-15
 */
@Service
public class TbScdDevServiceImpl extends ServiceImpl<TbScdDevMapper, TbScdDev> implements TbScdDevService {
    @Autowired
    private TbScdDevMapper tbScdDevMapper;
    @Autowired
    private TbScdApplyService tbScdApplyService;
    @Autowired
    private TbScdApplyItemService tbScdApplyItemService;
    /**
     * 获取设备列表
     *
     * @param page
     * @param tbScdDev
     * @return
     */
    @Override
    public R getPageList(Page<TbScdDev> page, TbScdDev tbScdDev) {
        IPage iPage = tbScdDevMapper.getPageList(page,tbScdDev);
        return R.ok(iPage);
    }

    /**
     * 设备申请
     * @param tbscdApplyVO
     * @return
     */
    @Override
    @Transactional
    public R devApplication(TbscdApplyVO tbscdApplyVO) {
        Snowflake snowflake = IdUtil.createSnowflake(1, 1L);
        long applyNo = snowflake.nextId();
        tbscdApplyVO.setApplyNo(String.valueOf(applyNo));
        //TbScdUser user = (TbScdUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        tbscdApplyVO.setApplyEmp(4L);
        tbscdApplyVO.setStatus(0);
        tbscdApplyVO.setApplyTime(LocalDateTime.now());
        tbscdApplyVO.setCreateTime(LocalDateTime.now());
        tbscdApplyVO.setIsValid(1);
        boolean save = tbScdApplyService.save(tbscdApplyVO);
        //获取插入申请表记录的id
        Long applyId = tbscdApplyVO.getId();
        TbScdApplyItem applyItem = new TbScdApplyItem();
        applyItem.setDevId(tbscdApplyVO.getDevId());
        applyItem.setApplyId(applyId);
        applyItem.setCreateTime(LocalDateTime.now());
        applyItem.setDevNum(tbscdApplyVO.getDevNum());
        boolean save1 = tbScdApplyItemService.save(applyItem);
        TbScdDev tbScdDev = tbScdDevMapper.selectById(tbscdApplyVO.getDevId());
        if (tbscdApplyVO.getDevNum()>tbScdDev.getDevSum()){
            throw new CommonException(501,"该设备数量不足");
        }
        tbScdDev.setDevSum(tbScdDev.getDevSum()-tbscdApplyVO.getDevNum());
        int i = tbScdDevMapper.updateById(tbScdDev);
        if (i<=0){
            return R.failed("申请失败");
        }
        return R.ok(true);
    }
}
