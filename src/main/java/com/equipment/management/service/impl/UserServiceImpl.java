package com.equipment.management.service.impl;

import com.equipment.management.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description //TODO
 * @Date 2021/1/11 23:29
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
