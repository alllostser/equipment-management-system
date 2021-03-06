package com.equipment.management.filter;

import com.equipment.management.config.RsaKeyproperties;
import com.equipment.management.entity.security.MyUserDetails;
import com.equipment.management.entity.security.Payload;
import com.equipment.management.utils.JwtUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

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
 * @description: 验证过滤器
 * @author: Guxinyu
 * @created: 2020/09/18 17:30
 */
public class JwtVerifyFilter extends BasicAuthenticationFilter {
    private RsaKeyproperties rsaKeyproperties;

    public JwtVerifyFilter(AuthenticationManager authenticationManager, RsaKeyproperties rsaKeyproperties) {
        super(authenticationManager);
        this.rsaKeyproperties = rsaKeyproperties;
    }

    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        boolean debug = this.logger.isDebugEnabled();
        String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
            //如果没有认证则给提示请登录
            chain.doFilter(request, response);
            try {
                response.setContentType("application/json;charset=utf-8");
                response.setStatus(HttpServletResponse.SC_FORBIDDEN);
                PrintWriter out = response.getWriter();
                Map<String,Object> result = new HashMap();
                result.put("code",HttpServletResponse.SC_FORBIDDEN);
                result.put("msg","请先登录！");
                out.write(new ObjectMapper().writeValueAsString(result));
                out.flush();
                out.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        } else {
            //如果携带了正确格式的token
            String token = header.replace("Bearer ","");
            Payload<MyUserDetails> payload = JwtUtils.getInfoFromToken(token,rsaKeyproperties.getPublicKey(),MyUserDetails.class);
            MyUserDetails userInfo = payload.getUserInfo();
            if (userInfo!=null){
                UsernamePasswordAuthenticationToken authResult = new UsernamePasswordAuthenticationToken(userInfo,null,userInfo.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(authResult);
                chain.doFilter(request, response);
            }

        }
    }

}
