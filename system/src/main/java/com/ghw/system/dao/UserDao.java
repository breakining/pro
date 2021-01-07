package com.ghw.system.dao;

import com.ghw.system.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @description: ???
 * @author: ghwei
 * @version: 1.0 2020/9/27 15:17
 */
@Repository
public class UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int save(UserDto user) {
        String sql = "insert into t_user (username,password,fullname,mobile) values (?,?,?,?);";
        //连接数据库查询用户
        return jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getFullname(), user.getMobile());
    }
}
