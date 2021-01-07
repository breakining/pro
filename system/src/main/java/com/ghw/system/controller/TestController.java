package com.ghw.system.controller;

import com.ghw.system.model.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 测试controller
 * @author: ghwei
 * @version: 1.0 2020/9/23 16:51
 */
@RestController
@Slf4j
public class TestController {

    @GetMapping(value = "/test/r1")
    @PreAuthorize("hasAnyAuthority('p1')")
    public String r1(){
        UserDto user =
                (UserDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getUsername() + "访问资源1";
    }


    @PreAuthorize("hasAuthority('p2')")
    @GetMapping(value = "/test/r2")
    public String r2(){//通过Spring Security API获取当前登录用户
        UserDto user =
                (UserDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return user.getUsername() + "访问资源2";
    }


}
