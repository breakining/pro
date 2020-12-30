package com.ghw.system.service;

import com.ghw.system.model.User;

/**
 * @description: ???
 * @author: ghwei
 * @version: 1.0 2020/9/27 15:14
 */
public interface IUserService {

    User create(String username, String password);
}
