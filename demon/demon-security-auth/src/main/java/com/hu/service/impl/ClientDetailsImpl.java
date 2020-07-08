//package com.hu.service.impl;
//
//import lombok.Data;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.oauth2.provider.ClientDetails;
//
//import java.util.Collection;
//import java.util.Map;
//import java.util.Set;
//
///**
// * @author : hudelin
// * @className :ClientDetailsImpl
// * @description :
// * @date: 2020-07-08 10:52
// */
//@Data
//public class ClientDetailsImpl implements ClientDetails {
//    @Override
//    public String getClientId() {
//        return "client";
//    }
//
//    @Override
//    public Set<String> getResourceIds() {
//        return null;
//    }
//
//    @Override
//    public boolean isSecretRequired() {
//        return true;
//    }
//
//    @Override
//    public String getClientSecret() {
//        return "secret";
//    }
//
//    @Override
//    public boolean isScoped() {
//        return false;
//    }
//
//    @Override
//    public Set<String> getScope() {
//        return null;
//    }
//
//    @Override
//    public Set<String> getAuthorizedGrantTypes() {
//        Set<String> s=Set.of("authorization_code", "refresh_token", "implicit", "password", "client_credentials");
//        return s;
//    }
//
//    @Override
//    public Set<String> getRegisteredRedirectUri() {
//        return null;
//    }
//
//    @Override
//    public Collection<GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    /**
//     * 此客户端的访问令牌有效期，单位：秒；
//     */
//    @Override
//    public Integer getAccessTokenValiditySeconds() {
//        return 60 * 60 * 24;
//    }
//
//    /**
//     * 此客户端的刷新令牌有效期，单位：秒；
//     */
//    @Override
//    public Integer getRefreshTokenValiditySeconds() {
//        return 60 * 60 * 24 * 30;
//    }
//
//    @Override
//    public boolean isAutoApprove(String s) {
//        return false;
//    }
//
//    @Override
//    public Map<String, Object> getAdditionalInformation() {
//        return null;
//    }
//}
