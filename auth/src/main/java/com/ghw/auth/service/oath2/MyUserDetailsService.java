package com.ghw.auth.service.oath2;

import com.alibaba.fastjson.JSON;
import com.ghw.auth.dao.UserDao;
import com.ghw.auth.model.PermissionDto;
import com.ghw.auth.model.UserDto;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description: ???
 * @author: ghwei
 * @version: 1.0 2020/9/27 14:34
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto userDto = userRepository.getUserByUsername(username);
        if (userDto == null) {
            //如果用户查不到，返回null，由provider来抛出异常
            return null;
        }
        //根据用户的id查询用户的权限
        List<String> permissions = userRepository.findPermissionsByUserId(userDto.getId());
        String[] perArray = new String[permissions.size()];
        permissions.toArray(perArray);
        UserDetails userDetails = User.withUsername(JSON.toJSONString(userDto))
                .password(userDto.getPassword())
                .authorities(perArray)
                .build();
        return userDetails;
    }
}
