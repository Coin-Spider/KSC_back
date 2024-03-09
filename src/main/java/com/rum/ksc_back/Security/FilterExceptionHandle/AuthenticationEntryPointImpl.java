package com.rum.ksc_back.Security.FilterExceptionHandle;

import cn.hutool.json.ObjectMapper;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.rum.ksc_back.Config.Request;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        response.setContentType("application/json;charset=UTF-8");
        if (Objects.isNull(request.getHeader("Token")) || request.getHeader("Token").isBlank()) {
            //Token 异常
            response.getWriter().println(JSON.toJSONString(new Request("403", "Token违规或过期")));
        } else {
            response.getWriter().println(JSON.toJSONString(new Request("403", "认证失败")));
        }
    }
}
