package com.ghw.auth.dao;

import com.ghw.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description: ???
 * @author: ghwei
 * @version: 1.0 2020/9/27 14:36
 */
public interface UserDao extends JpaRepository<User, Long> {

    User findByUsername(String username);

    User save(User user);
}
