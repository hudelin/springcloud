package com.hu.service.impl;

import com.hu.pojo.bo.UserExtend;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author : hudelin
 * @className :UserDetailsServiceImpl
 * @description : 重写security登录的用户信息注册
 * @date: 2020-07-07 10:40
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        return UserExtend.build("123","123",true,null);
    }
}
