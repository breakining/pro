package com.ghw.auth.adapter;

import com.ghw.auth.service.oath2.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.sql.DataSource;

/**
 * @description: ???
 * @author: ghwei
 * @version: 1.0 2020/9/23 14:44
 */
@Configuration
@EnableAuthorizationServer
public class CodeAuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //添加客户端信息
        clients.inMemory()                  // 使用in-memory存储客户端信息
                .withClient("client")       // client_id
                .secret("secret")                   // client_secret
                .authorizedGrantTypes("authorization_code")     // 该client允许的授权类型
                .scopes("app");
    }
}