package com.hu.pojo.dto;

import lombok.Data;

/**
 * @author : hudelin
 * @className :LoginDTO
 * @description : 登录dto
 * @date: 2020-07-07 10:32
 */
@Data
public class LoginDTO {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
