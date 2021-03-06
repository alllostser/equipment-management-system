package com.equipment.management.handler;

import com.equipment.management.utils.ResultUtil;
import lombok.SneakyThrows;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: AccessDeineHandler 用来解决认证过的用户访问无权限资源时的异常
 * @author: Guxinyu
 * @created: 2020/09/18 17:30
 */
public class JwtAccessDeniedHandler implements AccessDeniedHandler {
    /**
     * 当用户尝试访问需要权限才能的REST资源而权限不足的时候，
     * 将调用此方法发送403响应以及错误信息
     */
    @SneakyThrows
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        Map<String,Object> result = new HashMap();
        result.put("errCode",HttpServletResponse.SC_FORBIDDEN);
        result.put("errMsg","权限不足");
        result.put("status","failed");
        ResultUtil.responseJson(response,result);
    }
}
