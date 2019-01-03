package com.yh.springcloudoauth2.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 * 保护授权服务器。
 * 当客户端应用程序需要获取访问令牌时，它将在简单的表单登录驱动的身份验证过程之后执行
 * 密码流不需要表单登录配置 - 仅适用于隐式流 - 因此您可以根据您正在使用的OAuth2流来跳过它。
 * 继承 WebSecurityConfigurerAdapter 实现访问资源之前的拦截配置。该拦截器的顺序在资源服务器拦截器之前
 */
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

/*    // 自动注入UserDetailsService
    @Autowired
    private BaseUserDetailService baseUserDetailService;*/
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
      //  auth.authenticationProvider(daoAuthenticationProvider());
        //验证规则
        auth.inMemoryAuthentication()
                .withUser("john").password("123").roles("USER");
        /**
         *    auth.userDetailsService(urlUserService).passwordEncoder(new PasswordEncoder() {
         *
         *             @Override
         *             public String encode(CharSequence rawPassword) {
         *                 return MD5Util.encode((String) rawPassword);
         *             }
         *
         *             @Override
         *             public boolean matches(CharSequence rawPassword, String encodedPassword) {
         *                 return encodedPassword.equals(MD5Util.encode((String) rawPassword));
         *             }
         *         });
         */
    }

/*    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        // 设置userDetailsService
        provider.setUserDetailsService(baseUserDetailService);
        // 禁止隐藏用户未找到异常
        provider.setHideUserNotFoundExceptions(false);
        // 使用BCrypt进行密码的hash
        provider.setPasswordEncoder(new BCryptPasswordEncoder(6));
        return provider;
    }*/



    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean()
            throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()

                .antMatchers("/login").permitAll()
                // 其余所有请求全部需要鉴权认证,即在登录后，任何请求都可以直接访问
                .anyRequest().authenticated()
                .and()
                // 配置登陆页/login并允许访问
                .formLogin().permitAll();//登录页面任意访问
              // 由于使用的是JWT，我们这里不需要csrf
            //   .and().csrf().disable();
    }
}