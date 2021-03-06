package com.equipment.management.config;
import com.equipment.management.filter.JwtLoginFilter;
import com.equipment.management.filter.JwtVerifyFilter;
import com.equipment.management.handler.JwtAccessDeniedHandler;
import com.equipment.management.handler.JwtAuthenticationEntryPoint;
import com.equipment.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @ClassName WebSecurityConfig
 * @Description //TODO
 * @Date 2021/1/11 23:23
 * @Version 1.0
 **/
@Configurable
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;

    @Autowired
    private RsaKeyproperties rsaKeyproperties;

    /**
     * 将加密对象放到容器
     *
     * @return
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 配置数据源
     * @param auth
     * @throws Exception
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("user").password("{noop}123").roles("USER");
       auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }


    /**
     * 配置某些接口直接不进入过滤链，在security的config中配置
     * @param web
     */
    @Override
    public void configure(WebSecurity web) {
        //解决静态资源被拦截的问题   TODO 放行资源不走过滤链
        web.ignoring().antMatchers("/static/**");
    }

    /**
     *  置SpringSecurity相关规则
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilter(new JwtLoginFilter(super.authenticationManager(), rsaKeyproperties,userService))
                .addFilter(new JwtVerifyFilter(super.authenticationManager(),rsaKeyproperties,userService))
                //禁用session
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                //认证异常处理
                .exceptionHandling().authenticationEntryPoint(new JwtAuthenticationEntryPoint())
                // 授权异常处理
                .accessDeniedHandler(new JwtAccessDeniedHandler())
                .and()
                .cors()
                .and()
                .csrf().disable()
                .authorizeRequests()
                //配置需要放行的资源（即不需要认证就可以访问的资源）
                .antMatchers("/login","/category/list2","/category/list3","/statistics/getDevApplicationNum","/statistics/getDevApplicationQuantity").permitAll()
                //设定需要认证（登录）后才可以访问的资源
//                .antMatchers("/**").authenticated()
                .and()
                .formLogin()
                .loginPage("/login.html")  //指定登录页是"/login"
                .and().headers().frameOptions().disable();
        ;
    }

}
