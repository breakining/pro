package com.ghw.system.config.oath2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @description: 这里 Spring Security 的配置与传统的 Security 大体相同，不同在于：
 * 这里多了两个 Bean，这两个 Bean 将注入授权服务器配置类中使用。
 * 另外，这里的 HttpSecurity 配置主要是配置“oauth/**”模式的 URL，这一类的请求直接放行。
 * 注意：在这个 Spring Security 配置和上面的资源服务器配置中，都涉及到了 HttpSecurity。
 * 其中 Spring Security 中的配置优先级高于资源服务器中的配置，即请求地址先经过 Spring Security 的 HttpSecurity，
 * 再经过资源服务器的 HttpSecurity。
 * @author: ghwei
 * @version: 1.0 2020/9/23 15:07
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * 安全拦截机制（最重要）
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                // .antMatchers("/r/r1").hasAuthority("p2")
                // .antMatchers("/r/r2").hasAuthority("p2")
                .antMatchers("/r/**").authenticated()//所有/r/**的请求必须认证通过
                .anyRequest().permitAll();//除了/r/**，其它的请求可以访问
    }
}