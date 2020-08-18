package com.hu.service.impl;

import com.google.common.collect.Lists;
import com.hu.pojo.bo.UserExtend;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : hudelin
 * @className :UserDetailsServiceImpl
 * @description : 重写security登录的用户信息注册
 * @date: 2020-07-07 10:40
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private final static String ROLE_PREFIX = "ROLE_";

    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(ROLE_PREFIX +"USER");
        grantedAuthorities.add(grantedAuthority);
        return UserExtend.build("user",passwordEncoder.encode("123456"),true,grantedAuthorities);
    }
}
