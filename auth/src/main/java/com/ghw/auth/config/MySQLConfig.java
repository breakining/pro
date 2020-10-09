package com.ghw.auth.config;

import org.hibernate.dialect.MySQL57Dialect;
import org.springframework.context.annotation.Configuration;

/**
 * mysql 配置
 *
 * @author ghw
 * @version 1.0 2020-06-07  17:40:05
 */
@Configuration
public class MySQLConfig extends MySQL57Dialect {

    @Override
    public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}