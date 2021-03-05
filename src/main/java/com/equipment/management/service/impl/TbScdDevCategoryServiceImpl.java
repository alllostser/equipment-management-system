package com.equipment.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.equipment.management.entity.TbScdDevCategory;
import com.equipment.management.entity.dto.TbScdDevCategoryDto;
import com.equipment.management.entity.vo.TbScdDevCategoryVO;
import com.equipment.management.mapper.TbScdDevCategoryMapper;
import com.equipment.management.service.TbScdDevCategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 设备类别表 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2021-01-15
 */
@Service
@AllArgsConstructor
public class TbScdDevCategoryServiceImpl extends ServiceImpl<TbScdDevCategoryMapper, TbScdDevCategory> implements TbScdDevCategoryService {
    private final TbScdDevCategoryMapper tbScdDevCategoryMapper;


    /**
     * 获取所有分类列表
     * @return
     */
    @Override
    public List<TbScdDevCategoryVO> getCategoryList() {
        List<TbScdDevCategory> tbScdDevCategories = baseMapper.selectList(new LambdaQueryWrapper<TbScdDevCategory>().eq(TbScdDevCategory::getParentId,0).eq(TbScdDevCategory::getIsValid,1));
        List<TbScdDevCategoryVO> devCategoryDtoList = new ArrayList<>();
        //pojp转dto
        tbScdDevCategories.forEach(dct-> {
            TbScdDevCategoryVO vo = new TbScdDevCategoryVO();
            BeanUtils.copyProperties(dct,vo);
            devCategoryDtoList.add(vo);
        });
        List<TbScdDevCategoryVO> categoryList2 = getCategoryList2(devCategoryDtoList);
        return categoryList2;
    }

    /**
     * 获取指定id下的子级菜单
     * @param parentId
     * @return
     */
    @Override
    public List<TbScdDevCategoryVO> listByParentId(Integer parentId) {
        List<TbScdDevCategory> tbScdDevCategories = baseMapper.selectList(new LambdaQueryWrapper<TbScdDevCategory>().eq(TbScdDevCategory::getId, parentId));
        List<TbScdDevCategoryVO> devCategoryDtoList = new ArrayList<>();
        //pojp转dto
        tbScdDevCategories.forEach(dct-> {
            TbScdDevCategoryVO dto = new TbScdDevCategoryVO();
            BeanUtils.copyProperties(dct,dto);
            devCategoryDtoList.add(dto);
        });
        List<TbScdDevCategoryVO> categoryList2 = getCategoryList2(devCategoryDtoList);
        return categoryList2;
    }

    /**
     * 递归获取分类子节点
     * @param list
     * @return
     */
    private List<TbScdDevCategoryVO> getCategoryList2(List<TbScdDevCategoryVO> list){
        for (TbScdDevCategoryVO dto : list) {
            //获取该分类下所有子类
            List<TbScdDevCategoryVO> tbScd = baseMapper.selectList2(dto.getId());
            //递归获取子类的子类
            List<TbScdDevCategoryVO> categoryList2 = getCategoryList2(tbScd);
            dto.setChildren(categoryList2);
        }
        return list;
    }

    /**
     * 管理员获取分类列表
     * @return
     */
    @Override
    public List<TbScdDevCategoryVO> getCategoryList2() {
        List<TbScdDevCategory> tbScdDevCategories = baseMapper.selectList(new LambdaQueryWrapper<TbScdDevCategory>().eq(TbScdDevCategory::getParentId,0));
        List<TbScdDevCategoryVO> devCategoryDtoList = new ArrayList<>();
        //pojp转dto
        tbScdDevCategories.forEach(dct-> {
            TbScdDevCategoryVO vo = new TbScdDevCategoryVO();
            BeanUtils.copyProperties(dct,vo);
            devCategoryDtoList.add(vo);
        });
        List<TbScdDevCategoryVO> categoryList2 = getCategoryList3(devCategoryDtoList);
        return categoryList2;
    }

    /**
     * 递归获取分类子节点
     * @param list
     * @return
     */
    private List<TbScdDevCategoryVO> getCategoryList3(List<TbScdDevCategoryVO> list){
        for (TbScdDevCategoryVO dto : list) {
            //获取该分类下所有子类
            List<TbScdDevCategoryVO> tbScd = baseMapper.selectList3(dto.getId());
            //递归获取子类的子类
            List<TbScdDevCategoryVO> categoryList2 = getCategoryList3(tbScd);
            dto.setChildren(categoryList2);
        }
        return list;
    }

}
