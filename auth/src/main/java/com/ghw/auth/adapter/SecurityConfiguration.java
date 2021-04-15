package com.ghw.auth.adapter;

import com.ghw.auth.service.oath2.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
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

//    @Bean
//    @Override
//    protected UserDetailsService userDetailsService() {
//        //1阶段：创建了两个用户user_1和user_2，后续会以存mysql数据的方式来完善。
//        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//        String finalPassword = bCryptPasswordEncoder.encode("123456");
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("user_1").password(finalPassword).authorities("USER").build());
//        manager.createUser(User.withUsername("user_2").password(finalPassword).authorities("USER").build());
//        return manager;
//    }

    /**
     * 配置全局设置
     * @param auth
     * @throws Exception
     */
//    @Autowired
//    private void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        //设置UserDetailsService以及密码规则
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }

    /**
     * 密码编码器
     * @return
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder(); //给所有的密码前面加上{bcrypt}
        //return new BCryptPasswordEncoder();
    }

    /**
     * 认证管理器
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/auth_service/oauth/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin();
    }
}