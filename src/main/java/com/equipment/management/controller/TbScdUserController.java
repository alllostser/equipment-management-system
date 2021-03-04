package com.equipment.management.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.equipment.management.common.TableDataInfo;
import com.equipment.management.entity.TbScdUser;
import com.equipment.management.service.TbScdUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2021-01-15
 */
@RestController
@RequestMapping("/user")
public class TbScdUserController {
    @Autowired
    private TbScdUserService tbScdUserService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 获取用户列表+模糊查询
     * @param page
     * @param user
     * @return
     */
    @GetMapping("/list")
    public TableDataInfo list(Page page, TbScdUser user){
       IPage userPage =  tbScdUserService.listPage(page,user);
       return TableDataInfo.ResponseBySucess("成功",userPage.getTotal(),userPage.getRecords());
    }

    /**
     * 更新用户
     * @param tbScdUser
     * @return
     */
    @PostMapping("/update")
    public R update(@RequestBody TbScdUser tbScdUser){
        if (ObjectUtils.isEmpty(tbScdUser.getId())){
            return R.failed("id不能为空");
        }
        if (ObjectUtils.isEmpty(tbScdUser.getUserPwd())){
            String encode = bCryptPasswordEncoder.encode("123456");
            tbScdUser.setUserPwd(encode);
        }else {
            String encode = bCryptPasswordEncoder.encode(tbScdUser.getUserPwd());
            tbScdUser.setUserPwd(encode);
        }
        boolean update = tbScdUserService.updateById(tbScdUser);
        if (!update){
            return R.failed("更新失败");
        }
        return R.ok(update);
    }

    /**
     * 添加用户
     * @param tbScdUser
     * @return
     */
    @PostMapping("/insert")
    public R insert(@RequestBody TbScdUser tbScdUser){
        tbScdUser.setCreateTime(LocalDateTime.now());
        tbScdUser.setIsValid(1);
        if (ObjectUtils.isEmpty(tbScdUser.getUserPwd())){
            String encode = bCryptPasswordEncoder.encode("123456");
            tbScdUser.setUserPwd(encode);
        }else {
            String encode = bCryptPasswordEncoder.encode(tbScdUser.getUserPwd());
            tbScdUser.setUserPwd(encode);
        }
        boolean save = tbScdUserService.save(tbScdUser);
        if (!save){
            return R.failed("添加失败");
        }
        return R.ok(save);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    @DeleteMapping("/delete")
    public R deleteByIds(String ids){
        List<String> asids = Arrays.asList(ids.split(","));
         int delete = tbScdUserService.deleteByIds(asids);
         return R.ok(delete);
    }

    @GetMapping("/updateIsValid/{Id}")
    public R updateIsValid(@PathVariable Long Id){
        TbScdUser byId = tbScdUserService.getById(Id);
        if (byId.getIsValid()==0){
            byId.setIsValid(1);
        }else {
            byId.setIsValid(0);
        }
        boolean b = tbScdUserService.updateById(byId);
        if (!b){
            return R.failed("修改失败");
        }
        return R.ok("修改成功");
    }
}

