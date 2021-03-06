package com.equipment.management.handler;

import com.equipment.management.utils.ResultUtil;
import lombok.SneakyThrows;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: AuthenticationEntryPoint 用来解决匿名用户访问需要权限才能访问的资源时的异常
 * @author: Guxinyu
 * @created: 2020/09/18 17:30
 */
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    /**
     * 当用户尝试访问需要权限才能的REST资源而不提供Token或者Token错误或者过期时，
     * 将调用此方法发送401响应以及错误信息
     */
    @SneakyThrows
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        Map<String,Object> result = new HashMap();
        result.put("errCode",HttpServletResponse.SC_UNAUTHORIZED);
        result.put("errMsg","用户未登录");
        result.put("status","failed");
        ResultUtil.responseJson(response,result);
    }
}
