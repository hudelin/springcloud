package com.hu.pojo.bo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @author : hudelin
 * @className :UserExtend
 * @description : 拓展security用户信息
 * @date: 2020-07-07 10:43
 */
@Getter
@Setter
@ToString
public class UserExtend extends User {

    public UserExtend(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public UserExtend(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public static UserExtend build(String username, String password, boolean enabled, Collection<? extends GrantedAuthority> authorities) {
        return new UserExtend(username, password,authorities);
    }
}
