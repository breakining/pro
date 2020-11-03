package com.ghw.system.oath2;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * @description: 资源服务器的配置类
 * @author: ghwei
 * @version: 1.0 2020/9/27 11:21
 */
@Configuration
@EnableResourceServer  //注解开启资源服务的功能
@EnableGlobalMethodSecurity(prePostEnabled = true)  //开户方法级别的保护
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId("rid") // 配置资源id，这里的资源id和授权服务器中的资源id一致
                .stateless(true); // 设置这些资源仅基于令牌认证
    }

    @Override  // 配置 URL 访问权限
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("admin") // 配置admin访问控制，必须有admin角色才可以访问
                .antMatchers("/user/**").hasRole("user")   // 配置user访问控制，必须有user角色才可以访问
                .antMatchers("/order/**").authenticated()  // 配置order访问控制，必须认证后才可以访问
                .antMatchers("/product/**").permitAll()  // 配置product访问控制,放开
                .anyRequest().authenticated();  //其余的，需要认证
    }
}
