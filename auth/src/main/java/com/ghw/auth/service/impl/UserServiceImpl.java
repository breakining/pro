package com.ghw.auth.service.impl;

import com.ghw.auth.dao.UserDao;
import com.ghw.auth.model.User;
import com.ghw.auth.service.IUserService;
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
    public User create(String username, String password) {
        User user = new User();
        user.setUsername(username);
        password = "{bcrypt}" + passwordEncoder.encode(password);
        user.setPassword(password);
        User u = userDao.save(user);
        return u;
    }
}
