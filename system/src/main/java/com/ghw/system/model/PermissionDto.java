package com.ghw.system.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author Administrator
 * @version 1.0
 **/
@Data
public class PermissionDto implements GrantedAuthority {

    private String id;
    private String code;
    private String description;
    private String url;

    @Override
    public String getAuthority() {
        return code;
    }
}
