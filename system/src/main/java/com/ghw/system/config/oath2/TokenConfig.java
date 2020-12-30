package com.ghw.system.config.oath2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;


/**
 * @description: token的存储方式：jwt
 * @author: ghwei
 * @version: 1.0 2020/12/14 0:03
 */
@Configuration
public class TokenConfig {

    private String SIGNING_KEY = "jwt123456";

    /**
     * token的存储方式
     * @return
     */
    @Bean
    public TokenStore tokenStore() {
        //jwt
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey(SIGNING_KEY); //对称秘钥，资源服务器使用该秘钥来验证
        return converter;
    }
}
