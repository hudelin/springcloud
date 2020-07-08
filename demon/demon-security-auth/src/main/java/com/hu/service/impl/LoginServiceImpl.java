package com.hu.service.impl;

import com.hu.exception.BusinessException;
import com.hu.pojo.bo.OauthTokenResponse;
import com.hu.pojo.dto.PasswordLoginDTO;
import com.hu.pojo.vo.LoginSuccessVO;
import com.hu.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author : hudelin
 * @className :LoginServiceImpl
 * @description : 登录服务类实现
 * @date: 2020-07-07 10:38
 */
@Service
@Slf4j(topic = "LOGIN_LOG")
public class LoginServiceImpl implements LoginService {

    @Resource
    private RestTemplate restTemplate;

    @Override
    public LoginSuccessVO pwdLogin(PasswordLoginDTO passwordLoginDTO) {

        String accountType = passwordLoginDTO.getAccountType();
        String userName = passwordLoginDTO.getUsername();
        String password = passwordLoginDTO.getPassword();

        return requestAccessToken(buildLoginParam(accountType, userName, password, true));
    }


    /**
     * 获取 access_token
     * @param requestParam
     * @return
     */
    private LoginSuccessVO requestAccessToken(MultiValueMap<String, String> requestParam){
//        ServiceInstance serviceInstance = loadBalancerClient.choose(ServiceInstanceConstant.RAIN_AUTH);
//        if(serviceInstance == null){
//            throw BusinessException.operate("当前系统不稳定，请检查注册中心状态");
//        }
//
//        String url = serviceInstance.getUri() + "/auth/oauth/token";
        String url = "http://demon-security-auth/demon-security-auth/oauth/token";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(requestParam, headers);
        try{
            OauthTokenResponse response = restTemplate.postForObject(url, request, OauthTokenResponse.class);
//            return LoginSuccessVO.builder()
//                    .accessToken(response.getAccess_token())
//                    .build();
            return LoginSuccessVO.builder()
                    .accessToken(response.getAccess_token())
                    .build();
        }catch (Exception e){
            log.info("授权失败:{}", e.getMessage());
            throw BusinessException.operate("账号不可用");
        }
    }

    /**
     * 构建登录请求参数
     * @param accountType
     * @param userName
     * @param password
     * @param pwdLogin
     * @return
     */
    private MultiValueMap<String, String> buildLoginParam(String accountType, String userName, String password, boolean pwdLogin){
        MultiValueMap<String, String> param= new LinkedMultiValueMap<String, String>();
        param.add("username", userName);
        param.add("password", password);
        param.add("grant_type", "password");
        param.add("client_id", "client");
        param.add("client_secret", "secret");
        // 刷新token的用户类型
        param.add("account_type", accountType);
        // 是否密码登录
        param.add("pwdLogin", pwdLogin ? "true" : "false");
        return param;
    }
}
