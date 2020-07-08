package com.hu.pojo.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author : hudelin
 * @className :PasswordLoginDTO
 * @description : 密码登录dto
 * @date: 2020-07-07 10:32
 */
@Data
public class PasswordLoginDTO {

    /**
     * 用户名
     */
    @NotBlank(message = "账号不能为空")
    private String username;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 账号类型
     */
    @NotBlank(message = "账号类型不能为空")
    private String accountType;
}
