package com.equipment.management.filter;


import com.equipment.management.config.RsaKeyproperties;
import com.equipment.management.entity.security.MyUserDetails;
import com.equipment.management.utils.JwtUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: securtitydemo
 * @description: 重写认证过滤器
 * @author: Guxinyu
 * @created: 2020/09/18 17:06
 */
public class JwtLoginFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;
    private RsaKeyproperties rsaKeyproperties;
    private final static Integer TOKEN_EXPIRATION_TIME = 60*6;

    public JwtLoginFilter(AuthenticationManager authenticationManager, RsaKeyproperties rsaKeyproperties) {
        this.authenticationManager = authenticationManager;
        this.rsaKeyproperties = rsaKeyproperties;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
            try {
                MyUserDetails loginUser = new ObjectMapper().readValue(request.getInputStream(), MyUserDetails.class);
                UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword());
                this.setDetails(request, authRequest);
                return this.authenticationManager.authenticate(authRequest);
            }catch (InternalAuthenticationServiceException | IOException e){

                try {
                    response.setContentType("application/json;charset=utf-8");
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    PrintWriter out = response.getWriter();
                    Map<String,Object> result = new HashMap();
                    result.put("code",HttpServletResponse.SC_UNAUTHORIZED);
                    result.put("msg","用户名和密码不能为空！");
                    out.write(new ObjectMapper().writeValueAsString(result));
                    out.flush();
                    out.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                throw new RuntimeException(e);
            }
    }


    @Override
    public void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        MyUserDetails user = (MyUserDetails) authResult.getPrincipal();
        user.setPassword(null);
        String token = JwtUtils.generateTokenExpireInMinutes(user, rsaKeyproperties.getPrivateKey(), TOKEN_EXPIRATION_TIME);
        //response.addHeader("Authorization","Bearer "+token);
        SecurityContextHolder.getContext().setAuthentication(authResult);
        try {
            response.setContentType("application/json;charset=utf-8");
            response.setStatus(HttpServletResponse.SC_OK);
            PrintWriter out = response.getWriter();
            Map<String,Object> result = new HashMap();
            result.put("code",HttpServletResponse.SC_OK);
            result.put("msg","认证通过！");
            result.put("type","Bearer");
            result.put("token",token);
            out.write(new ObjectMapper().writeValueAsString(result));
            out.flush();
            out.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
