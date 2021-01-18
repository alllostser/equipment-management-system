package com.equipment.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.equipment.management.entity.TbScdDevCategory;
import com.equipment.management.entity.dto.TbScdDevCategoryDto;
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
    public List<TbScdDevCategoryDto> getCategoryList() {
        List<TbScdDevCategory> tbScdDevCategories = baseMapper.selectList(new LambdaQueryWrapper<TbScdDevCategory>().eq(TbScdDevCategory::getParentId,0));
        List<TbScdDevCategoryDto> devCategoryDtoList = new ArrayList<>();
        //pojp转dto
        tbScdDevCategories.forEach(dct-> {
            TbScdDevCategoryDto dto = new TbScdDevCategoryDto();
            BeanUtils.copyProperties(dct,dto);
            devCategoryDtoList.add(dto);
        });
        List<TbScdDevCategoryDto> categoryList2 = getCategoryList2(devCategoryDtoList);
        return categoryList2;
    }

    /**
     * 获取指定id下的子级菜单
     * @param parentId
     * @return
     */
    @Override
    public List<TbScdDevCategoryDto> listByParentId(Integer parentId) {
        List<TbScdDevCategory> tbScdDevCategories = baseMapper.selectList(new LambdaQueryWrapper<TbScdDevCategory>().eq(TbScdDevCategory::getId, parentId));
        List<TbScdDevCategoryDto> devCategoryDtoList = new ArrayList<>();
        //pojp转dto
        tbScdDevCategories.forEach(dct-> {
            TbScdDevCategoryDto dto = new TbScdDevCategoryDto();
            BeanUtils.copyProperties(dct,dto);
            devCategoryDtoList.add(dto);
        });
        List<TbScdDevCategoryDto> categoryList2 = getCategoryList2(devCategoryDtoList);
        return categoryList2;
    }

    /**
     * 递归获取分类子节点
     * @param list
     * @return
     */
    private List<TbScdDevCategoryDto> getCategoryList2(List<TbScdDevCategoryDto> list){
        for (TbScdDevCategoryDto dto : list) {
            //获取该分类下所有子类
            List<TbScdDevCategoryDto> tbScd = baseMapper.selectList2(dto.getId());
            //递归获取子类的子类
            List<TbScdDevCategoryDto> categoryList2 = getCategoryList2(tbScd);
            dto.setChildCategory(categoryList2);
        }
        return list;
    }
}
