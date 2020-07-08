package com.hu.pojo.bo;

import lombok.Data;

/**
 * @author : hudelin
 * @className :OauthTokenResponse
 * @description : 获取token返回值
 * @date: 2020-07-07 15:44
 */
@Data
public class OauthTokenResponse {

    /**
     * access_token
     */
    private String access_token;

    /**
     * token_type
     */
    private String token_type;

    /**
     * refresh_token
     */
    private String refresh_token;

    /**
     * expires_in
     */
    private String expires_in;

    /**
     * scope
     */
    private String scope;

}
