package com.hu.service;

import com.hu.pojo.dto.LoginDTO;

/**
 * @author : hudelin
 * @className :LoginService
 * @description : 登录服务类接口
 * @date: 2020-07-07 10:38
 */
public interface LoginService {
     String loginAdmin(LoginDTO loginDTO);
}
