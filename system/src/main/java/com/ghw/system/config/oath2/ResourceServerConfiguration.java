package com.ghw.system.config.oath2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @description: 资源服务器的配置类
 * @author: ghwei
 * @version: 1.0 2020/9/27 11:21
 */
@Configuration
@EnableResourceServer  //注解开启资源服务的功能
@EnableGlobalMethodSecurity(prePostEnabled = true)  //开户方法级别的保护
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    public static final String RESOURCE_ID = "res1";


    @Autowired
    private TokenStore tokenStore;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID) // 配置资源id，这里的资源id和授权服务器中的资源id一致
                //.tokenServices(tokenService())
                .tokenStore(tokenStore)
                .stateless(true); // 设置这些资源仅基于令牌认证
    }

    @Override  // 配置 URL 访问权限
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/admin/**").hasRole("admin") // 配置admin访问控制，必须有admin角色才可以访问
                .antMatchers("/user/**").hasRole("user")   // 配置user访问控制，必须有user角色才可以访问
                .antMatchers("/order/**").authenticated()  // 配置order访问控制，必须认证后才可以访问
                .antMatchers("/test/**").authenticated()  // 配置product访问控制,放开
                .antMatchers("/product/**").permitAll()  // 配置product访问控制,放开
                .antMatchers("/**").access("#oauth2.hasScope('all')") //scope必须为all
                .anyRequest().authenticated()   //其余的，需要认证
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS); //禁用session
    }

    //资源服务令牌解析服务；如果是jwt方式存储令牌，则不用这个
    @Bean
    public ResourceServerTokenServices tokenService() {
        //使用远程服务请求授权服务器校验token,必须指定校验token 的url、client_id，client_secret
        RemoteTokenServices service = new RemoteTokenServices();
        service.setCheckTokenEndpointUrl("http://localhost:7781/auth_service/oauth/check_token");
        service.setClientId("client_1");
        service.setClientSecret("123456");
        return service;
    }
}
