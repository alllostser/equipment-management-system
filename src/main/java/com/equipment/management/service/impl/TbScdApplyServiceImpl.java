package com.equipment.management.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.equipment.management.entity.TbScdApply;
import com.equipment.management.entity.TbScdDev;
import com.equipment.management.entity.TbScdUser;
import com.equipment.management.entity.dto.TbScdApplyDto;
import com.equipment.management.entity.security.MyUserDetails;
import com.equipment.management.entity.vo.TbscdApplyVO;
import com.equipment.management.mapper.TbScdApplyMapper;
import com.equipment.management.mapper.TbScdDevMapper;
import com.equipment.management.service.TbScdApplyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.equipment.management.service.TbScdUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
     * 获取个人申请列表
     * @param page
     * @param tbScdApplyDto
     * @return
     */
    @Override
    public IPage<TbScdApplyDto> listPage2(Page<TbScdApplyDto> page, TbScdApplyDto tbScdApplyDto) {
        MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long id = user.getId();
        IPage<TbScdApplyDto> iPage = tbScdApplyMapper.listPage2(page, tbScdApplyDto,id);
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
        MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        tbScdApplyVO.setDealTime(LocalDateTime.now());
        if (tbScdApplyVO.getStatus()!=5 || tbScdApplyVO.getStatus()!=4){
            tbScdApplyVO.setDealEmp(user.getId());
        }
        if (user.getUserRole()==2){
            if (tbScdApplyVO.getStatus()==2){
                tbScdApplyVO.setStatus(1);
                int result = baseMapper.updateStatusById(tbScdApplyVO);
                return result;
            }else if (tbScdApplyVO.getStatus()==4){
                TbScdDev tbScdDev = tbScdDevMapper.selectById(tbScdApplyVO.getDevId());
                tbScdDev.setDevSum(tbScdDev.getDevSum()+tbScdApplyVO.getDevNum());
                int i = tbScdDevMapper.updateById(tbScdDev);
            }
            int result = baseMapper.updateStatusById(tbScdApplyVO);
            return result;
        }
        int result = baseMapper.updateStatusById(tbScdApplyVO);
        if (tbScdApplyVO.getStatus()==2){
            TbScdDev tbScdDev = tbScdDevMapper.selectById(tbScdApplyVO.getDevId());
            tbScdDev.setDevSum(tbScdDev.getDevSum()-tbScdApplyVO.getDevNum());
            int i = tbScdDevMapper.updateById(tbScdDev);
        }else if (tbScdApplyVO.getStatus()==4){
            TbScdDev tbScdDev = tbScdDevMapper.selectById(tbScdApplyVO.getDevId());
            tbScdDev.setDevSum(tbScdDev.getDevSum()+tbScdApplyVO.getDevNum());
            int i = tbScdDevMapper.updateById(tbScdDev);
        }
        return result;
    }
}
