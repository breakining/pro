package com.ghw.system.dao;

import com.ghw.system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @description: ???
 * @author: ghwei
 * @version: 1.0 2020/9/27 15:17
 */
public interface UserDao extends JpaRepository<User, Long> {
}
