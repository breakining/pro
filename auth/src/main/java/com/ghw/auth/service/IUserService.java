package com.ghw.auth.service;

import com.ghw.auth.model.User;

/**
 * @description: ???
 * @author: ghwei
 * @version: 1.0 2020/9/27 15:14
 */
public interface IUserService {

    User create(String username, String password);
}
