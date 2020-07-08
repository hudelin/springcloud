package com.hu.service;

import com.hu.pojo.dto.PasswordLoginDTO;
import com.hu.pojo.vo.LoginSuccessVO;

/**
 * @author : hudelin
 * @className :LoginService
 * @description : 登录服务类接口
 * @date: 2020-07-07 10:38
 */
public interface LoginService {

     /**
      * 密码登录
      * @param passwordLoginDTO
      * @return
      */
     LoginSuccessVO pwdLogin(PasswordLoginDTO passwordLoginDTO);
}
