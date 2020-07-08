package com.hu.config;

import com.hu.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

import javax.annotation.Resource;

/**
 * @author : hudelin
 * @className :AuthorizationServerConfig
 * @description : Oauth2配置类
 * @date: 2020-07-07 15:19
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Resource
    private UserDetailsServiceImpl userDetailsServiceImpl;

    /**
     * 注入用于支持 password 模式
     */
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                // 用于支持密码模式
                .authenticationManager(authenticationManager)
//                .tokenStore(tokenStore())
                .userDetailsService(userDetailsServiceImpl)
        ;

    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer
                // 允许客户端访问 /oauth/check_token 检查 token
                .allowFormAuthenticationForClients()
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("permitAll()");
    }

    /**
     * 配置客户端
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients
                // 使用内存设置
                .inMemory()
                // client_id
                .withClient("client")
                //client_secret passwordEncoder.encode("secret")
                .secret("$2a$10$nQInQwRnPK77kAwMW97gPej0lV1o1sn5jEXOdNxk68vXogV8BrWNG")
                //授权类型，密码模式和刷新令牌
                .authorizedGrantTypes("authorization_code", "refresh_token", "implicit", "password", "client_credentials")
                // 授权范围
                .scopes("backend")
                .redirectUris("http://127.0.0.1:8086/demon-security-auth/auth/user")
                // 可以设置对哪些资源有访问权限，不设置则全部资源都可以访问
                .resourceIds("backend-resources")
                // 设置访问令牌的有效期，这里是 1 天
                .accessTokenValiditySeconds(60 * 60 * 24)
                // 设置刷新令牌的有效期，这里是 30 天
                .refreshTokenValiditySeconds(60 * 60 * 24 * 30);
    }
}
