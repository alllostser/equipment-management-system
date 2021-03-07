package com.equipment.management.service.impl;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.equipment.management.common.TableDataInfo;
import com.equipment.management.entity.TbScdApplyItem;
import com.equipment.management.entity.TbScdDev;
import com.equipment.management.entity.excel.ExcelForDev;
import com.equipment.management.entity.security.MyUserDetails;
import com.equipment.management.entity.vo.TbscdApplyVO;
import com.equipment.management.exception.CommonException;
import com.equipment.management.mapper.TbScdDevMapper;
import com.equipment.management.service.TbScdApplyItemService;
import com.equipment.management.service.TbScdApplyService;
import com.equipment.management.service.TbScdDevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

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
    public TableDataInfo getPageList(Page<TbScdDev> page, TbScdDev tbScdDev) {
        IPage iPage = tbScdDevMapper.getPageList(page,tbScdDev);
        return TableDataInfo.ResponseBySucess("成功",iPage.getTotal(),iPage.getRecords());
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
        tbscdApplyVO.setApplyNo("AP"+String.valueOf(applyNo).substring(0,7));
        //todo: 当前登录用户
        MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        tbscdApplyVO.setApplyEmp(user.getId());
        if (user.getUserRole()==1){
            tbscdApplyVO.setStatus(2);
        }
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
        //tbScdDev.setDevSum(tbScdDev.getDevSum()-tbscdApplyVO.getDevNum());
        int i = tbScdDevMapper.updateById(tbScdDev);
        if (i<=0){
            return R.failed("申请失败");
        }
        return R.ok(true);
    }

    @Override
    public boolean deleteByIds(List<String> asList) {
        int i = baseMapper.deleteBatchIds(asList);
        if (i<=0){
            return false;
        }
        return true;
    }

    @Override
    public List<ExcelForDev> list2() {
        List<ExcelForDev> excelForDevs = baseMapper.list2();
        return excelForDevs;
    }

    @Override
    public void saveList(List<ExcelForDev> list) {
            int result = baseMapper.saveExcelForDev(list);
    }
}
