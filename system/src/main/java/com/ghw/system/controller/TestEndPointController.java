package com.ghw.system.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * @description: 第三方断点登录测试
 * @author: ghwei
 * @version: 1.0 2020/9/27 11:30
 */
@RestController
@Slf4j
public class TestEndPointController {


    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable String id) {
        return "product id : " + id;
    }

    @GetMapping("/order/{id}")
    public String getOrder(@PathVariable String id) {
        return "order id : " + id;
    }

    @GetMapping("/getPrinciple")
    public OAuth2Authentication getPrinciple(OAuth2Authentication oAuth2Authentication, Principal principal, Authentication authentication) {
        log.info(oAuth2Authentication.getUserAuthentication().getAuthorities().toString());
        log.info(oAuth2Authentication.toString());
        log.info("principal.toString() " + principal.toString());
        log.info("principal.getName() " + principal.getName());
        log.info("authentication: " + authentication.getAuthorities().toString());
        return oAuth2Authentication;
    }
}