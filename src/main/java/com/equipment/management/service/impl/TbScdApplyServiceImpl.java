package com.equipment.management.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.equipment.management.entity.TbScdApply;
import com.equipment.management.entity.TbScdDev;
import com.equipment.management.entity.TbScdUser;
import com.equipment.management.entity.dto.TbScdApplyDto;
import com.equipment.management.entity.vo.TbscdApplyVO;
import com.equipment.management.mapper.TbScdApplyMapper;
import com.equipment.management.mapper.TbScdDevMapper;
import com.equipment.management.service.TbScdApplyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.equipment.management.service.TbScdUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 设备申请表 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2021-01-15
 */
@Service
public class TbScdApplyServiceImpl extends ServiceImpl<TbScdApplyMapper, TbScdApply> implements TbScdApplyService {
    @Autowired
    private TbScdApplyMapper tbScdApplyMapper;
    @Autowired
    private TbScdUserService tbScdUserService;
    @Autowired
    private TbScdDevMapper tbScdDevMapper;

    /**
     * 设备申请借用列表
     * @param page
     * @param tbScdApplyDto
     * @return
     */
    @Override
    public IPage<TbScdApplyDto> listPage(Page<TbScdApplyDto> page, TbScdApplyDto tbScdApplyDto) {
        IPage<TbScdApplyDto> iPage = tbScdApplyMapper.listPage(page, tbScdApplyDto);
        List<TbScdApplyDto> records = iPage.getRecords();
        for (TbScdApplyDto record : records) {
            if (StringUtils.checkValNull(record.getDealEmp())){
                continue;
            }
            TbScdUser tbScdUser = tbScdUserService.getById(record.getDealEmp());
            String realName = tbScdUser.getRealName();
            record.setDealName(realName);
        }
        iPage.setRecords(records);
        return iPage;
    }

    /**
     * 审核请求
     * @param tbScdApplyVO
     * @return
     */
    @Override
    public int updateStatusById(TbscdApplyVO tbScdApplyVO) {
        tbScdApplyVO.setDealTime(LocalDateTime.now());
//        tbScdApply.setDealEmp();
        int result = baseMapper.updateStatusById(tbScdApplyVO);
        if (tbScdApplyVO.getStatus()==2){
            TbScdDev tbScdDev = tbScdDevMapper.selectById(tbScdApplyVO.getDevId());
            tbScdDev.setDevSum(tbScdDev.getDevSum()-tbScdApplyVO.getDevNum());
            int i = tbScdDevMapper.updateById(tbScdDev);
        }
        return result;
    }
}
