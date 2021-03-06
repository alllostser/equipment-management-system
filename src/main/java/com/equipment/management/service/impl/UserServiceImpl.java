package com.equipment.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.equipment.management.entity.TbScdRole;
import com.equipment.management.entity.security.MyUserDetails;
import com.equipment.management.mapper.TbScdRoleMapper;
import com.equipment.management.mapper.TbScdUserMapper;
import com.equipment.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Description //TODO
 * @Date 2021/1/11 23:29
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TbScdUserMapper tbScdUserMapper;
    @Autowired
    private TbScdRoleMapper tbScdRoleMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUserDetails byName = tbScdUserMapper.findByName(username);
        if (byName == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        Integer userRole = byName.getUserRole();
        List<TbScdRole> tbScdRoles = tbScdRoleMapper.selectList(new LambdaQueryWrapper<TbScdRole>().eq(TbScdRole::getId, userRole));
        byName.setRoles(tbScdRoles);
        return byName;
    }
}
