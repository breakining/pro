package com.ghw.system.service.impl;

import com.ghw.system.dao.UserDao;
import com.ghw.system.model.UserDto;
import com.ghw.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @description: ???
 * @author: ghwei
 * @version: 1.0 2020/9/27 15:16
 */
@Service
public class UserServiceImpl implements IUserService {

    private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private UserDao userDao;

    @Override
    public int create(String username, String password) {
        UserDto user = new UserDto();
        user.setUsername(username);
        password = "{bcrypt}" + passwordEncoder.encode(password);
        user.setPassword(password);
        return userDao.save(user);
    }
}
