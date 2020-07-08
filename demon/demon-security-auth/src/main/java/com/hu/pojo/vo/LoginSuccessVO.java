package com.hu.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : hudelin
 * @className :LoginSuccessVO
 * @description : 登录成功返回视图
 * @date: 2020-07-08 15:29
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginSuccessVO {

    /**
     * accessToken
     */
    private String accessToken;

    /**
     * 仅微信登录有值
     */
    private String sessionKey;
}
