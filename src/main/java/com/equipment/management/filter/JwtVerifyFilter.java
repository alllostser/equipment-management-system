package com.equipment.management.filter;

import com.equipment.management.common.SecurityConstants;
import com.equipment.management.config.RsaKeyproperties;
import com.equipment.management.entity.security.MyUserDetails;
import com.equipment.management.entity.security.Payload;
import com.equipment.management.service.UserService;
import com.equipment.management.utils.JwtUtils;
import com.equipment.management.utils.ResultUtil;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.SignatureException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 验证过滤器
 * @author: Guxinyu
 * @created: 2020/09/18 17:30
 */
@Slf4j
public class JwtVerifyFilter extends BasicAuthenticationFilter {
    private RsaKeyproperties rsaKeyproperties;
    private final UserService userDetailsService;

    public JwtVerifyFilter(AuthenticationManager authenticationManager, RsaKeyproperties rsaKeyproperties, UserService userDetailsService) {
        super(authenticationManager);
        this.rsaKeyproperties = rsaKeyproperties;
        this.userDetailsService = userDetailsService;
    }

    /**
     * 验证是否带有指定请求头
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @SneakyThrows
    @Override
    public void doFilterInternal(HttpServletRequest request,
                                 HttpServletResponse response,
                                 FilterChain chain) throws IOException, ServletException {
        String token = request.getHeader(SecurityConstants.TOKEN_HEADER);
        String id = request.getHeader("id");
        if (token != null && !token.isEmpty()) {
            if (token.startsWith(SecurityConstants.TOKEN_PREFIX)) {
                UsernamePasswordAuthenticationToken authentication = getAuthentication(token, response);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
            chain.doFilter(request, response);
        }
    }
    /**
     *  获取用户认证信息 Authentication
     * @param authorization
     * @return
     */
    public UsernamePasswordAuthenticationToken getAuthentication(String authorization,HttpServletResponse response) {
        log.info("get authentication");
        String token = authorization.replace(SecurityConstants.TOKEN_PREFIX, "");
        try {
            Payload<MyUserDetails> payload = JwtUtils.getInfoFromToken(token, rsaKeyproperties.getPublicKey(), MyUserDetails.class);
            log.info("checking username:" + payload.toString());
            if (!StringUtils.isEmpty(payload)) {
                // 这里是又从数据库拿了一遍,避免用户的角色信息有变，可以不拿
                MyUserDetails userDetails = (MyUserDetails) userDetailsService.loadUserByUsername(payload.getUserInfo().getUsername());
                userDetails.setPassword("");
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                return userDetails.isEnabled() ? usernamePasswordAuthenticationToken : null;
            }
        } catch (SignatureException  | MalformedJwtException | IllegalArgumentException | IOException exception) {
            log.error("Request to parse JWT with invalid signature . Detail : " + exception.getMessage());
        } catch (ExpiredJwtException e) {
            log.error("Request to parse JWT with invalid signature . Detail : " + e.getMessage());
            Map<String, Object> result = new HashMap();
            result.put("errCode", HttpServletResponse.SC_PAYMENT_REQUIRED);
            result.put("errMsg", "token已过期");
            result.put("status", "failed");
            ResultUtil.responseJson(response, result);
        }
        return null;
    }
}
