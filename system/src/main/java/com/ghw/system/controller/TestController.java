package com.ghw.system.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
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
    //@PreAuthorize("hasAnyAuthority('USER')")
    public String r1(){
        return "访问资源1";
    }

}
