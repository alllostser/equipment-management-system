package com.equipment.management.filter;

import com.equipment.management.config.RsaKeyproperties;
import com.equipment.management.entity.security.MyUserDetails;
import com.equipment.management.service.UserService;
import com.equipment.management.utils.JwtUtils;
import com.equipment.management.utils.ResultUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 重写认证过滤器
 * @author: Guxinyu
 * @created: 2020/09/18 17:06
 */
@Slf4j
public class JwtLoginFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;
    private RsaKeyproperties rsaKeyproperties;
    private UserService userService;
    //令牌过期时间
    private final static Integer TOKEN_EXPIRATION_TIME = 60 * 24;

    public JwtLoginFilter(AuthenticationManager authenticationManager, RsaKeyproperties rsaKeyproperties, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.rsaKeyproperties = rsaKeyproperties;
        this.userService = userService;
    }

    /**
     * 认证用户名密码
     * @param request
     * @param response
     * @return
     * @throws AuthenticationException
     */
    @SneakyThrows
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        MyUserDetails loginUser = new ObjectMapper().readValue(request.getInputStream(), MyUserDetails.class);
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword());
        this.setDetails(request, authRequest);
        return this.authenticationManager.authenticate(authRequest);
    }


    /**
     * 认证成功调用
     * @param request
     * @param response
     * @param chain
     * @param authResult
     * @throws IOException
     * @throws ServletException
     */
    @SneakyThrows
    @Override
    public void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        MyUserDetails user = (MyUserDetails) authResult.getPrincipal();
        user.setPassword("");
        String token = JwtUtils.generateTokenExpireInMinutes(user, rsaKeyproperties.getPrivateKey(), TOKEN_EXPIRATION_TIME);
        response.addHeader("Authorization", "Bearer " + token);
        Map<String, Object> result = new HashMap();
        result.put("code", HttpServletResponse.SC_OK);
        result.put("msg", "登陆成功");
        result.put("username", user.getUsername());
        result.put("role", user.getUserRole());
        result.put("status", "successed");
        result.put("Authorization", "Bearer " + token);
        logger.info("用户：" + user.getUsername() + "成功登录");
        ResultUtil.responseJson(response, result);
    }

    /**
     * 认证失败调用
     * @param request
     * @param response
     * @param failed
     * @throws IOException
     * @throws ServletException
     */
    @SneakyThrows
    @Override
    public void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        String msg = "";
        if (failed instanceof LockedException) {
            log.info("账户被锁定，请联系管理员!");
            msg = "账户被锁定，请联系管理员!";
        } else if (failed instanceof CredentialsExpiredException) {
            log.info("密码过期，请联系管理员!");
            msg = "密码过期，请联系管理员!";
        } else if (failed instanceof AccountExpiredException) {
            log.info("账户过期，请联系管理员!");
            msg = "账户过期，请联系管理员!";
        } else if (failed instanceof DisabledException) {
            log.info("账户被禁用，请联系管理员!");
            msg = "账户被禁用，请联系管理员!";
        } else if (failed instanceof BadCredentialsException) {
            log.info("用户名或者密码输入错误，请重新输入!");
            msg = "用户名或者密码输入错误，请重新输入!";
        } else {
            log.info(failed.getMessage());
            msg = failed.getMessage();
        }
        Map<String, Object> result = new HashMap();
        result.put("errCode", HttpServletResponse.SC_UNAUTHORIZED);
        result.put("errMsg", msg);
        result.put("status", "failed");
        ResultUtil.responseJson(response, result);
    }
}
