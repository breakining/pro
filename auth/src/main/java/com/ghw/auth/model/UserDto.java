package com.ghw.auth.model;


import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @description: user
 * @author: ghwei
 * @version: 1.0 2020/9/27 14:38
 */
@Data
public class UserDto implements UserDetails, Serializable {

    private String id;

    private String username;

    private String password;

    private String fullname;

    private String mobile;

    private List<PermissionDto> authorities;

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

