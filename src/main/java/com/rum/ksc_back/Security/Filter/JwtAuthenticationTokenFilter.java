package com.rum.ksc_back.Security.Filter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.interfaces.Claim;
import com.rum.ksc_back.Dao.UserMapper;
import com.rum.ksc_back.KSCException.ApiException;
import com.rum.ksc_back.Security.Secret.KSCAuthenticationProvider;
import com.rum.ksc_back.Security.SecurityUser;
import com.rum.ksc_back.Utils.JwtUtil;
import com.rum.ksc_back.domain.Ron.KSCUser;
import jakarta.annotation.Resource;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

@Configuration
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    @Autowired
    private UserMapper userMapper;
    @Resource private KSCAuthenticationProvider kscAuthenticationProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (request.getRequestURI().contains("/User/Login")) {
            filterChain.doFilter(request, response);
            return;
        }
        String token = request.getHeader("Token");
        if (Objects.isNull(token) || token.isBlank()||token.split("\\.").length!=3) {
            filterChain.doFilter(request, response);
            return;
        }
        if (token.startsWith("Bearer ")) {
            token = token.split("Bearer ")[1];
        }
        if (!JwtUtil.chTimeEx(token)) {
            throw new ApiException("0003", "token过期");
        }
        String userName = String.valueOf(JWT.decode(token).getClaim("userName"));
        if (userName.isBlank()) {
            throw new ApiException("0004", "Token无效");
        }
//        System.out.println(userName);
        SecurityUser s= (SecurityUser) kscAuthenticationProvider.loadUserByUsername(userName);
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(s, s.getPassword(), s.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        filterChain.doFilter(request, response);
    }
}
