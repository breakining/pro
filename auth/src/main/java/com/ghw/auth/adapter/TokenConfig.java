package com.ghw.auth.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.sql.DataSource;

/**
 * @description: token的存储方式
 * @author: ghwei
 * @version: 1.0 2020/12/14 0:03
 */
@Configuration
public class TokenConfig {

    private String SIGNING_KEY = "jwt123456";

    //以下配置jdbc
    @Autowired
    private DataSource dataSource;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    /**
     * token的存储方式
     * @return
     */
    @Bean
    public TokenStore tokenStore() {
        //1.内存存储
        //return new InMemoryTokenStore();
        //2阶段.存储redis
        //RedisTokenStore redis = new RedisTokenStore(redisConnectionFactory);
        //return redis;
        //3阶段.存储数据库
        //return new JdbcTokenStore(dataSource);
        //4.jwt
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(SIGNING_KEY); //对称秘钥，资源服务器使用该秘钥来验证
        return converter;
    }
}
