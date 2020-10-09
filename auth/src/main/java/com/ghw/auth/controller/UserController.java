package com.ghw.auth.controller;

import com.ghw.auth.model.User;
import com.ghw.auth.service.IUserService;
import com.ghw.base.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @description: ???
 * @author: ghwei
 * @version: 1.0 2020/9/23 16:51
 */
@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private IUserService userService;


    @RequestMapping(value = "/current", method = RequestMethod.GET)
    public Principal getUser(Principal principal) {
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>");
        log.info(principal.toString());
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>");
        return principal;
    }

    @RequestMapping(value = "/registry", method = RequestMethod.POST)
    public User createUser(@RequestParam("username") String username, @RequestParam("password") String password) {
        if (StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(password)) {
            return userService.create(username, password);
        }
        return null;
    }
}
